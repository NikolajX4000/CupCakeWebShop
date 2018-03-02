package Servlets;

import DBConnection.DAO;
import Data.Order;
import Data.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "adminOrderPage", urlPatterns
        = {
            "/adminOrder"
        })
public class adminOrderPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession s = request.getSession();
        s.setAttribute("curPage", "adminOrder");
        if (s.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
        } else {
            User user = (User) s.getAttribute("user");
            if (!user.getRole().equals("Admin")) {
                response.sendRedirect("index.jsp");
            } else {
                if (request.getParameter("id") != null) {
                    Order order = dao.getOrder(Integer.parseInt(request.getParameter("id")));
                    if (!order.getOrder().isEmpty()) {
                        request.setAttribute("orderDetails", order);
                        getServletContext().getRequestDispatcher("/adminSpecificOrderPage.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("adminOrder");
                    }
                } else {
                    request.setAttribute("allOrders", dao.getAllOrders());
                    getServletContext().getRequestDispatcher("/adminOrdersPage.jsp").forward(request, response);
                }
            }
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
