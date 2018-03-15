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

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
@WebServlet(name = "createPiece", urlPatterns
        = {
            "/createPiece"
        })
public class createPiece extends HttpServlet {

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

                if (request.getParameter("action") != null) {
                    if (request.getParameter("action").equals("newPiece")) {

                        String name = (String) request.getParameter("name");
                        double price = (double) Integer.parseInt(request.getParameter("price"));
                        String type = (String) request.getParameter("type");

                        if (type.equals("bottom")) {
                            dao.addBottom(name, price);
                        } else if (type.equals("topping")) {
                            dao.addTopping(name, price);
                        }
                    }
                }

                getServletContext().getRequestDispatcher("/createPiece.jsp").forward(request, response);

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
