package controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.DAO;
import model.User;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("Views/login.jsp").forward(request, response);
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

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPass");
        String phone = request.getParameter("phone");

        try {
            Date date = Date.valueOf(dob);
            if (isValidInput(email, password, confirmPass)) {
                createUserAccount(fullname, username, date, email, password, confirmPass);
                response.sendRedirect("Views/status.jsp");
            } else {

                request.getRequestDispatcher("Views/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }

        // Validate the input and create a new user account
    }

    private boolean isValidInput(String username, String password, String confirmPass) {
        List<User> us;
        DAO.INS.LoadAll();
        us = DAO.INS.getUser();
        for (User u : us) {
            if (u.getEmail().equals(username)) {
                return false;
            }
        }
        if (!password.equals(confirmPass)) {
            return false;
        }
        return true;
    }

    private void createUserAccount(String fullName, String userName, java.sql.Date dob, String email, String password,
            String phone) {
        DAO.INS.CreateAcc(fullName, userName, dob, email, password, phone, dob);
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
