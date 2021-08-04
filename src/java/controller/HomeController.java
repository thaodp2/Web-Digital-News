/*
 *Copyright(C) 2021, DINH PHUONG THAO
 * J3.L.P0004(Digital news):
 * Digital news
 *
 * Record of change:
 * DATE            Version             AUTHOR                  DESCRIPTION
 * 2021-05-28       1.0                DINH PHUONG THAO        First Implement
 * 2021-05-28       2.0                DINH PHUONG THAO        Second Implement
 * 2021-05-31       3.0                DINH PHUONG THAO        Third Implement
 * 2021-05-31       4.0                DINH PHUONG THAO        Four Implement
 * 2021-06-02       5.0                DINH PHUONG THAO        Five Implement
 */
package controller;

import dao.DigitalDAO;
import dao.impl.DigitalDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Digital;

/**
 * This class has a method that handles putting top 1, top5, and current news on
 * the home page Servlet will switch to error page when any error occurs;
 * <p>
 * Bugs: None
 *
 */
public class HomeController extends HttpServlet {

    /**
     * This function processes the data being called, then passes the data to
     * the jsp page for display. Handles the HTTP <code>GET</code> method.
     *
     * @param request is information sent from client to server.
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is the data that the server returns to the client.
     * <code>javax.servlet.http.HttpServletResponse</code> This method after
     * creating a digitalDAO object. It will then get data like: get new by id,
     * get top 5 news list, Convert date If the data has an error, the program
     * will go to the Error page.
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            ArrayList<Digital> digitals = digitalDAO.getAllTopNews(6);
            request.setAttribute("top1New",digitals.get(0));
            request.setAttribute("digitals", digitals);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
