package controller.admin;

import dal.LessonDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Lessons;
import model.Subject;

/**
 *
 * @author Admin
 */
public class UpdateLessonServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateLessonServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateLessonServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        LessonDAO ldao = new LessonDAO();
        SubjectDAO sdao = new SubjectDAO();
        List<Subject> lists = sdao.getAllSubjects();

        if (id_raw != null) {
            int id = Integer.parseInt(id_raw);
            Lessons lesson = ldao.getLessonById(id);

            request.setAttribute("lesson", lesson);
            request.setAttribute("lists", lists);
            request.getRequestDispatcher("update-lesson.jsp").forward(request, response);
        }
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
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String subjectName = request.getParameter("subjectName");
        String author = request.getParameter("createdBy");
        String date = request.getParameter("createdAt");
        String status = request.getParameter("status");
        String videoLink = request.getParameter("videoLink");
        String content = request.getParameter("content");

        LessonDAO ldao = new LessonDAO();
        try {
            int id = Integer.parseInt(id_raw);
            int subjectId = Integer.parseInt(subjectName);
            int createdBy = Integer.parseInt(author);
            Date createdAt = Date.valueOf(date);

            Lessons lesson = new Lessons(id, name, videoLink, createdAt, createdBy, subjectId, status, content);
            ldao.update(lesson);
            response.sendRedirect("lessons");
        } catch (Exception e) {
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
