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
import jakarta.servlet.http.Part;
import java.io.File;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Packages;
import model.Subject;

/**
 *
 * @author Admin
 */
public class AddSubjectServlet extends HttpServlet {

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
            out.println("<title>Servlet AddSubjectServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSubjectServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cdao = new CategoryDAO();
        PackageDAO pdao = new PackageDAO();
        List<Category> listca = cdao.getAllCategory();
        List<Packages> listp = pdao.getAllPackage();

        request.setAttribute("listca", listca);
        request.setAttribute("listp", listp);
        request.getRequestDispatcher("new-subject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectName = request.getParameter("subjectName");
        String description = request.getParameter("description");
        String lesson = request.getParameter("lessonId");
        String packages = request.getParameter("packageId");
        String category = request.getParameter("categoryId");
        String user = request.getParameter("userId");
        String rating = request.getParameter("ratingId");
        String date = request.getParameter("date");

        SubjectDAO sdao = new SubjectDAO();
        try {
            int lessonId = Integer.parseInt(lesson);
            int packageId = Integer.parseInt(packages);
            int categoryId = Integer.parseInt(category);
            int userId = Integer.parseInt(user);
            int ratingId = Integer.parseInt(rating);

            // Parse the date string to a Date object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date createdAt = sdf.parse(date);

            // Handle file upload
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("/") + "uploads" + File.separator + fileName;
            File file = new File(uploadPath);
            file.getParentFile().mkdirs(); // Create directories if not exist
            filePart.write(uploadPath);

            String images = "uploads/" + fileName;

            Subject subject = new Subject(subjectName, description, images, lessonId, packageId, categoryId, userId, ratingId, createdAt);
//            sdao.insert(subject);

            response.sendRedirect("subject-list");
        } catch (IOException | NumberFormatException | ParseException e) {
        }
        response.sendRedirect("subject-list");
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
