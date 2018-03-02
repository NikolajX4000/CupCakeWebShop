package Servlets;

import DBConnection.DAO;
import Data.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "usersPage", urlPatterns
        = {
            "/users"
        })
public class usersPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession s = request.getSession();
        s.setAttribute("curPage", "users");
        if (s.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (request.getParameter("id") != null) {
                request.setAttribute("orderDetails", dao.getOrder(Integer.parseInt(request.getParameter("id"))));
                getServletContext().getRequestDispatcher("/userSpecificOrderPage.jsp").forward(request, response);
            } else {
                User user = (User) s.getAttribute("user");
                request.setAttribute("usersOrders", dao.getUsersOrders(user.getId()));
                getServletContext().getRequestDispatcher("/userOrdersPage.jsp").forward(request, response);
            }
            //ArrayList<Order> getUsersOrders
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
