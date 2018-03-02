package Servlets;

import DBConnection.DAO;
import Data.CupCake;
import Data.CupCakePiece;
import Data.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "shopPage", urlPatterns
        = {
            "/shop"
        })
public class shopPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        session.setAttribute("curPage", "welcome");
        if (session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
        } else {
            ArrayList<CupCake> cart;
            if (session.getAttribute("cart") == null) {
                cart = new ArrayList();
                session.setAttribute("cart", cart);
            }
            if (request.getParameter("action") != null && request.getParameter("action").equals("addToOrder")) {
                cart = (ArrayList<CupCake>) session.getAttribute("cart");
                CupCakePiece bottom = dao.getBottom(Integer.parseInt(request.getParameter("bottom")));
                CupCakePiece topping = dao.getTopping(Integer.parseInt(request.getParameter("topping")));
                CupCake cupcake = new CupCake(bottom, topping, Integer.parseInt(request.getParameter("amount")));
                boolean contains = false;
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).equals(cupcake)) {
                        cart.get(i).addAmount(Integer.parseInt(request.getParameter("amount")));
                        contains = true;
                    }
                }
                if (contains == false) {
                    cart.add(cupcake);
                    session.setAttribute("cart", cart);
                }
            } else if (request.getParameter("action") != null && request.getParameter("action").equals("checkOut")) {
                cart = (ArrayList<CupCake>) session.getAttribute("cart");
                if (!cart.isEmpty()) {
                    User user = (User) session.getAttribute("user");
                    dao.insertOrder(cart, user);
                    session.setAttribute("cart", new ArrayList<CupCake>());
                }
            } else if (request.getParameter("action") != null && request.getParameter("action").equals("updateCart")) {
                cart = (ArrayList<CupCake>) session.getAttribute("cart");
                for (int i = 0; i < cart.size(); i++) {
                    cart.get(i).setAmount(Integer.parseInt(request.getParameter(Integer.toString(i))));
                }
            }
            request.setAttribute("toppings", dao.getToppings());
            request.setAttribute("bottoms", dao.getBottoms());
            getServletContext().getRequestDispatcher("/shopPage.jsp").forward(request, response);
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
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
