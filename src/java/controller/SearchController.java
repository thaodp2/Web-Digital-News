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

/**
 * This class has a method to handle searching for news by title, pagination
 * Servlet will switch to error page when any error occurs
 *
 * Bugs: None
 */
public class SearchController extends HttpServlet {

    /**
     * This function processes the data being called, then passes the data to
     * the jsp page for display. 
     * Handles the HTTP <code>GET</code> method.
     * Where it takes an input string search. After processing string input
     * search. Pass in string text search then return an array of new with title
     * including string search
     *
     * @param request is information sent from client to server.
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is the data that the server returns to the client.
     * <code>javax.servlet.http.HttpServletResponse</code> This function takes
     * the txtSearch value from the user input, gets the current index value
     * that the page currently has. 
     * If there are error problems, the page will go to the error page
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String txtSearch = request.getParameter("txtSearch");
            txtSearch = txtSearch == null ? "" : txtSearch;
            txtSearch = txtSearch.trim();
            request.setAttribute("txt", txtSearch);
            String indexStr = request.getParameter("index");
            indexStr = indexStr == null ? "1" : indexStr;
            int index = Integer.parseInt(indexStr);
            request.setAttribute("index", index);
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            ArrayList<Digital> digitals = digitalDAO.getAllTopNews(6);
            int totalNews = digitalDAO.countMaxNews(txtSearch);
            int pageSize = 3;
            int countNumberPage = totalNews / pageSize;
            if (totalNews % pageSize != 0) {
                countNumberPage++;
            }
            request.setAttribute("countNumberPage", countNumberPage);
            ArrayList<Digital> digitalsSearch = digitalDAO.getAllSearchDigital(txtSearch, index, pageSize);
            request.setAttribute("digitalsSearch", digitalsSearch);
            request.setAttribute("top1New", digitals.get(0));
            request.setAttribute("digitals", digitals);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
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
