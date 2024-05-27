/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vn.fpt.edu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import vn.fpt.edu.dao.CategoryDAO;
import vn.fpt.edu.dao.QuizDAO;
import vn.fpt.edu.dao.SubjectDAO;
import vn.fpt.edu.model.Category;
import vn.fpt.edu.model.Quiz;
import vn.fpt.edu.model.Subject;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
public class QuizManageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        String url = "quiz-list.jsp";
        switch (action) {
            case "view":
                viewQuizList(request, response);
                break;
            case "add":
                createQuizPage(request, response);
                break;
            case "update":
                updateQuizView(request, response);
                break;
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
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        String url = "create-quiz.jsp";
        switch (action) {
            case "add":
                addQuiz(request, response);
                break;
            case "update":
                updateQuiz(request, response);
                break;
            case "remove":
                removeQuiz(request, response);
                break;
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

    private void viewQuizList(HttpServletRequest request, HttpServletResponse response) {
        try {
            String url = "quiz-list.jsp";
            QuizDAO quizDAO = new QuizDAO();
            List<Quiz> listQuiz = quizDAO.getListQuiz();
            if (listQuiz != null) {
                request.setAttribute("QUIZS", listQuiz);
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addQuiz(HttpServletRequest request, HttpServletResponse response) {
        try {
            String url = "create-quiz.jsp";
            String title = request.getParameter("title");
            String description = request.getParameter("desc");
            Part image = request.getPart("image");
            String levelS = request.getParameter("level");
            String categoryIdS = request.getParameter("categoryId");
            String subjectIdS = request.getParameter("subjectId");

            int level = Integer.parseInt(levelS);
            int categoryId = Integer.parseInt(categoryIdS);
            int subject = Integer.parseInt(subjectIdS);
            Quiz quiz = new Quiz();

            QuizDAO quizDAO = new QuizDAO();
            quiz.setTitle(title);
            quiz.setDescription(description);

            quiz.setLevel(level);
            quiz.setCategoryID(categoryId);
            quiz.setSubjectID(subject);

            // Nhờ bạn login đưa id của người tạo vào đây nhé
//            quiz.setCreateById(userId);
            boolean result = quizDAO.addNewQuiz(quiz);
            if (result) {
                url = "quiz-list.jsp";
                List<Quiz> listQuiz = quizDAO.getListQuiz();
                request.setAttribute("QUIZS", listQuiz);
            } else {
                request.setAttribute("ERROR", "Create quiz failed");
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createQuizPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            String url = "create-quiz.jsp";;
            CategoryDAO categoryDAO = new CategoryDAO();
            SubjectDAO subjectDAO = new SubjectDAO();

            List<Category> listCategory = categoryDAO.GetAllCategory();
            List<Subject> listSubject = subjectDAO.GetAllSubjects();
            request.setAttribute("CATEGORY", listCategory);
            request.setAttribute("SUBJECT", listSubject);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeQuiz(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateQuizView(HttpServletRequest request, HttpServletResponse response) {
        try {
            String quizIds = request.getParameter("id");
            int quizId = Integer.parseInt(quizIds);
            String url = "update-quiz.jsp";;
            CategoryDAO categoryDAO = new CategoryDAO();
            SubjectDAO subjectDAO = new SubjectDAO();
            QuizDAO quizDAO = new QuizDAO();

            Quiz quiz = quizDAO.getQuizById(quizId);

            List<Category> listCategory = categoryDAO.GetAllCategory();
            List<Subject> listSubject = subjectDAO.GetAllSubjects();
            request.setAttribute("CATEGORY", listCategory);
            request.setAttribute("SUBJECT", listSubject);
            request.setAttribute("QUIZ", quiz);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateQuiz(HttpServletRequest request, HttpServletResponse response) {
        try {
            String url = "create-quiz.jsp";
            String title = request.getParameter("title");
            String idS = request.getParameter("id");
            String description = request.getParameter("desc");
            Part image = request.getPart("image");
            String levelS = request.getParameter("level");
            String categoryIdS = request.getParameter("categoryId");
            String subjectIdS = request.getParameter("subjectId");

            int level = Integer.parseInt(levelS);
            int categoryId = Integer.parseInt(categoryIdS);
            int subject = Integer.parseInt(subjectIdS);     
            int id = Integer.parseInt(idS);

            Quiz quiz = new Quiz();

            QuizDAO quizDAO = new QuizDAO();
            quiz.setTitle(title);
            quiz.setDescription(description);

            quiz.setLevel(level);
            quiz.setCategoryID(categoryId);
            quiz.setSubjectID(subject);
            quiz.setQuizID(id);

            // Nhờ bạn login đưa id của người tạo vào đây nhé
//            quiz.setCreateById(userId);
            boolean result = quizDAO.updateQuiz(quiz);
            if (result) {
                url = "quiz-list.jsp";
                List<Quiz> listQuiz = quizDAO.getListQuiz();
                request.setAttribute("QUIZS", listQuiz);
            } else {
                request.setAttribute("ERROR", "Create quiz failed");
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
