package controller.admin;

import dal.CategoryDAO;
import dal.PackageDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Category;
import model.Packages;
import model.Subject;

/**
 *
 * @author Admin
 */
public class SubjectAddServlet extends HttpServlet {

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
            out.println("<title>Servlet SubjectAddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectAddServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
//        CategoryDAO cdao = new CategoryDAO();
//        PackageDAO pdao = new PackageDAO();
//
//        List<Category> listca = cdao.getAllCategory();
//        List<Packages> listp = pdao.getAllPackage();
//
//        request.setAttribute("listCategories", listca);
//        request.setAttribute("listPackages", listp);
        request.getRequestDispatcher("addSubject.jsp").forward(request, response);
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
        //processRequest(request, response);

        String subjectName = request.getParameter("subjectName");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        int packageId = Integer.parseInt(request.getParameter("packageId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int ratingId = Integer.parseInt(request.getParameter("ratingId"));
        Date createdAt = Date.valueOf(request.getParameter("createdAt"));

        Subject subject = new Subject(subjectName, description, image, lessonId, packageId, categoryId, userId, ratingId, createdAt);

        SubjectDAO subjectDAO = new SubjectDAO();
        subjectDAO.insert(subject);

        response.sendRedirect("admin/subject-list");
    
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>n"

}
