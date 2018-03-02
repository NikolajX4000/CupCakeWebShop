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

@WebServlet(name = "welcomePage", urlPatterns
        = {
            "/welcome"
        })
public class welcomePage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession s = request.getSession();
        s.setAttribute("curPage", "welcome");
        if (s.getAttribute("user") != null) {
            response.sendRedirect("shop");
        } else {
            User user = null;
            String goHere = null;
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equals("login")) {
                    user = dao.login(request.getParameter("username"), request.getParameter("password"));
                    if (user != null) {
                        s.setAttribute("user", user);
                        goHere = "shop";
                    }
                }
                if (request.getParameter("action").equals("register")) {
                    boolean createdUser = dao.createCustomer(request.getParameter("username"), request.getParameter("password"), request.getParameter("password2"));
                    if (createdUser) {
                        goHere = "welcome";
                    }
                }
            }
            if (goHere != null) {
                response.sendRedirect(goHere);
            } else {
                //if(request.getReq("p") != null && request.getAttribute("p").equals("register")){
                if (request.getParameter("p") != null && request.getParameter("p").equals("register")) {
                    getServletContext().getRequestDispatcher("/createUserPage.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);
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
