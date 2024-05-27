/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuizDAO;
import Model.Quiz;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Datnt
 */
public class QuizManagementController extends HttpServlet {

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
                url = "create-quiz.jsp";
                request.getRequestDispatcher(url).forward(request, response);
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
            String content = request.getParameter("content");
            String description = request.getParameter("description");
            String durationS = request.getParameter("duration");

            Quiz quiz = new Quiz();
            QuizDAO quizDAO = new QuizDAO();
            quiz.setQuizContent(content);
            quiz.setQuizDescription(description);
            int duration = Integer.parseInt(durationS);
            quiz.setDuration(duration);

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

}
