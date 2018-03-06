/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBConnection.DAO;
import Data.CupCake;
import Data.CupCakePiece;
import Data.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    DAO dao = new DAO();
    HttpSession session = null;
    boolean doneShopping = false;

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

        session = request.getSession();
        session.setAttribute("curPage", "welcome");

        if (session.getAttribute("user") == null)
        {
            response.sendRedirect("index.jsp");
        } else
        {
            int orderID = 0;
            ArrayList<CupCake> cart;
            request.setAttribute("toppings", dao.getToppings());
            request.setAttribute("bottoms", dao.getBottoms());

            if (session.getAttribute("cart") == null)
            {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }

            if (request.getParameter("action") != null && request.getParameter("action").equals("addToOrder"))
            {
                addToOrder(request);
            } else if (request.getParameter("action") != null && request.getParameter("action").equals("checkOut"))
            {
                checkOut(response);
            } else if (request.getParameter("action") != null && request.getParameter("action").equals("updateCart"))
            {
                updateCart(request);
            }
            if (!doneShopping)
            {
                getServletContext().getRequestDispatcher("/shopPage.jsp").forward(request, response);
            }
        }
    }

    private void addToOrder(HttpServletRequest request)
    {
        ArrayList<CupCake> cart = (ArrayList<CupCake>) session.getAttribute("cart");
        CupCakePiece bottom = dao.getBottom(Integer.parseInt(request.getParameter("bottom")));
        CupCakePiece topping = dao.getTopping(Integer.parseInt(request.getParameter("topping")));
        CupCake cupcake = new CupCake(bottom, topping, Integer.parseInt(request.getParameter("amount")));

        boolean contains = false;
        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).equals(cupcake))
            {
                cart.get(i).addAmount(cupcake.getAmount());
                contains = true;
            }

        }
        if (contains == false)
        {
            cart.add(cupcake);
            session.setAttribute("cart", cart);
        }
    }

    private void updateCart(HttpServletRequest request)
    {
        ArrayList<CupCake> cart = (ArrayList<CupCake>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++)
        {
            cart.get(i).setAmount(Integer.parseInt(request.getParameter(Integer.toString(i))));
        }
    }

    private void checkOut(HttpServletResponse response)
    {
        ArrayList<CupCake> cart = (ArrayList<CupCake>) session.getAttribute("cart");
        int orderID = 0;
        if (!cart.isEmpty())
        {
            User user = (User) session.getAttribute("user");
            orderID = dao.insertOrder(cart, user);
            session.setAttribute("cart", new ArrayList<>());
            doneShopping = true;
        }
        try
        {
            response.sendRedirect("users?id=" + Integer.toString(orderID));
        } catch (IOException ex)
        {
            Logger.getLogger(shopPage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
