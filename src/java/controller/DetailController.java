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
 * 2021-06-02       6.0                DINH PHUONG THAO        Six Implement
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
import java.text.SimpleDateFormat;

/**
 * This class will include details handling operations. Including getting new
 * from id, getting a list of the last top 5 new.
 */
public class DetailController extends HttpServlet {

    /**
     * This function processes the data being called, then passes the data to
     * the jsp page for display. * Handles the HTTP <code>GET</code> method.
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
            String idText = request.getParameter("id");
            idText = idText == null ? "" : idText;
            int id = Integer.parseInt(idText);
            Digital digitalById = digitalDAO.getNewById(id);
            request.setAttribute("digitalById", digitalById);
            ArrayList<Digital> digitals = digitalDAO.getAllTopNews(6);
            request.setAttribute("top1New", digitals.get(0));
            request.setAttribute("digitals", digitals);
            String dateConvert = new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(digitalById.getDate()).toUpperCase();
            request.setAttribute("dateConvert", dateConvert);
            request.getRequestDispatcher("Detail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code> javax.servlet.http.HttpServletRequest </code>
     * @param response respond to an HTTP Request to the browser It is a <code> javax.servlet.http.HttpServletResponse
     * </code>
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
