/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBConnection.DAO;
import Data.CupCake;
import Data.CupCakePiece;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hupra Laptop
 */
@WebServlet(name = "shopPage", urlPatterns =
{
    "/shop"
})
public class shopPage extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();

        HttpSession s = request.getSession();
        ArrayList<CupCake> order = new ArrayList();

        if (s.getAttribute("order") == null)
        {
            s.setAttribute("order", order);
        }

        if (request.getParameter("action") != null && request.getParameter("action").equals("addToOrder"))
        {
            order = (ArrayList<CupCake>) s.getAttribute("order");
            CupCakePiece bottom = dao.getBottom((int)request.getAttribute("bottom"));
            CupCakePiece topping = dao.getBottom((int)request.getAttribute("topping")); 
            CupCake cupcake = new CupCake(bottom, topping, (int) request.getAttribute("amount"));
            order.add(cupcake);
            s.setAttribute("order", order);

        }
        request.setAttribute("toppings", dao.getToppings());
        request.setAttribute("bottoms", dao.getBottoms());
        getServletContext().getRequestDispatcher("/shopPage.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
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
