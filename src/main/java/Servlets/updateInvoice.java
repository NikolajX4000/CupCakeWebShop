/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBConnection.DAO;
import Data.Order;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jacob Borg
 */
@WebServlet(name = "updateInvoice", urlPatterns =
{
    "/updateInvoice"
})
public class updateInvoice extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.sendRedirect("adminOrder?id=" + Integer.parseInt(request.getParameter("orderID")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DAO dao = new DAO();
        int amount = 0;
        Order order = dao.getOrder(Integer.parseInt(request.getParameter("orderID")));
        for (int i = 0; i < order.getOrder().size(); i++)
        {
            amount = Integer.parseInt(request.getParameter(Integer.toString(i)));
            if (order.getOrder().get(i).getCupCake().getAmount() != amount)
            {
                dao.updateOrderLine(order.getOrder().get(i).getOrderlineId(), amount);
            }

        }
        

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
