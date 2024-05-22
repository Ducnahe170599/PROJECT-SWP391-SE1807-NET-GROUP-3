package controller.admin;

import dal.CategoryDAO;
import dal.PackageDAO;
import dal.RatingDAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Subject;
import model.Category;
import model.Packages;
import model.Ratings;
import model.User;

/**
 *
 * @author Admin
 */
public class UpdateSubjectServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateSubjectServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSubjectServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");  // Đảm bảo tham số này đúng là 'id'

        SubjectDAO sdao = new SubjectDAO();
        CategoryDAO cdao = new CategoryDAO();
        PackageDAO pdao = new PackageDAO();
        if (id_raw != null) {
            int id = Integer.parseInt(id_raw);
            Subject subject = sdao.getSubjectById(id);
            List<Category> listca = cdao.getAllCategory();
            List<Packages> listp = pdao.getAllPackage();

            request.setAttribute("listca", listca);
            request.setAttribute("subject", subject);
            request.setAttribute("listp", listp);
        }
        request.getRequestDispatcher("update-subject.jsp").forward(request, response);
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
        // Lấy dữ liệu từ form
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String category = request.getParameter("categoryId");
        String packages = request.getParameter("packageId");
        String userName = request.getParameter("userId");
        String rating = request.getParameter("ratingId");
        String image = request.getParameter("image");
        String status = request.getParameter("status");
        String createdAt = request.getParameter("date");
        String description = request.getParameter("description");

        SubjectDAO sdao = new SubjectDAO();

        try {
            // Chuyển đổi các giá trị cần thiết
            int id = Integer.parseInt(id_raw);
            int categoryId = Integer.parseInt(category);
            int packageId = Integer.parseInt(packages);
            int ratingId = Integer.parseInt(rating);
            int userId = Integer.parseInt(userName);
            Date date = Date.valueOf(createdAt);
            boolean statusValue = Boolean.parseBoolean(status);

            Subject subject = new Subject(id, name, description, image, statusValue, packageId, categoryId, userId, ratingId, date);
            sdao.updateSubject(subject);
        } catch (Exception e) {
            e.printStackTrace();  // In ra stack trace để debug
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
