package vn.fpt.edu.Controller;

import dal.RegistrationsAdd;
import dal.RegistrationsDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 * @author Admin
 */
public class RegistrationsController extends HttpServlet {

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
            out.println("<title>Servlet RegistrationsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationsController at " + request.getContextPath() + "</h1>");
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        RegistrationsDBContext registrationDB = new RegistrationsDBContext();
        List<RegistrationsAdd> registrations = registrationDB.getAllRegistrations();

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < registrations.size(); i++) {
            RegistrationsAdd registration = registrations.get(i);
            json.append("{")
                    .append("\"RegisterID\":").append(registration.getRegisterID()).append(",")
                    .append("\"UserID\":").append(registration.getUserID()).append(",")
                    .append("\"SubjectID\":").append(registration.getSubjectID()).append(",")
                    .append("\"PackageID\":").append(registration.getPackageID()).append(",")
                    .append("\"total_cost\":").append(registration.getTotal_cost()).append(",")
                    .append("\"status\":").append(registration.getStatus()).append(",")
                    .append("\"valid_from\":\"").append(registration.getValid_from()).append("\",")
                    .append("\"valid_to\":\"").append(registration.getValid_to()).append("\",")
                    .append("\"create_at\":\"").append(registration.getCreate_at()).append("\"")
                    .append("}");
            if (i < registrations.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        try (PrintWriter out = response.getWriter()) {
            out.print(json.toString());
        }
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
