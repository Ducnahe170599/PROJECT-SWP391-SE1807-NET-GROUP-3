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
import java.util.List;
import model.Category;
import model.Packages;
import model.Subject;

/**
 *
 * @author Admin
 */
public class SubjectListServlet extends HttpServlet {

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
            out.println("<title>Servlet SubjectListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectListServlet at " + request.getContextPath() + "</h1>");
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
        String txtSearch = request.getParameter("txtSearch");

        CategoryDAO cdao = new CategoryDAO();
        PackageDAO pdao = new PackageDAO();
        SubjectDAO sdao = new SubjectDAO();
        List<Category> listca = cdao.getAllCategory();
        List<Subject> lists;

        // Search //
        if (txtSearch != null && !txtSearch.isEmpty()) {
            List<Subject> searchByName = sdao.searchByName(txtSearch);
            if (searchByName == null || searchByName.isEmpty()) {
                request.setAttribute("mess", "Not Found Subject");
            }
            lists = searchByName;
        } else {
            lists = sdao.getAllSubjects();
        }
        int countSearch = sdao.countSearch(txtSearch);
        //System.out.println("The number of subject: " + countSearch);
        int pageSize = 5;
        int endPage = 0;
        endPage = countSearch / pageSize;
        if (countSearch % pageSize != 0) {
            endPage++;
        }
        request.setAttribute("endPage", endPage);

        request.setAttribute("listca", listca);
        request.setAttribute("lists", lists);
        request.setAttribute("txtSearch", txtSearch);
        request.getRequestDispatcher("subject-list.jsp").forward(request, response);
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
        CategoryDAO cdao = new CategoryDAO();
        PackageDAO pdao = new PackageDAO();
        SubjectDAO sdao = new SubjectDAO();

        List<Category> listca = cdao.getAllCategory();

        int cateid = request.getParameter("cateid") == null ? 0 : Integer.parseInt(request.getParameter("cateid"));
        int statusValue = request.getParameter("status") == null ? 0 : Integer.parseInt(request.getParameter("status"));

        List<Subject> lists = sdao.getSubjectsByCategoryAndStatus(cateid, statusValue);

        request.setAttribute("listca", listca);
        request.setAttribute("lists", lists);
        request.setAttribute("cateid", cateid);
        request.setAttribute("status", statusValue);

        request.getRequestDispatcher("subject-list.jsp").forward(request, response);

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
