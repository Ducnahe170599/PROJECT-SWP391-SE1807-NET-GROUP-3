/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAL.DBContext;
import Model.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Datnt
 */
public class QuizDAO extends DBContext {

    private Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public QuizDAO() {
        try {
            con = new DBContext().getConnection();
            System.out.println("Connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Quiz> getListQuiz() {
        String sql = "SELECT * FROM [Quiz]";
        List<Quiz> listQuiz = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizId"));
                quiz.setQuizContent(rs.getString("QuizContent"));
                quiz.setDuration(rs.getInt("Duration"));
                quiz.setQuizDescription(rs.getString("Description"));
                listQuiz.add(quiz);
            }
            return listQuiz;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addNewQuiz(Quiz quiz) {
        String sql = "INSERT INTO Quiz (QuizContent, Description, CategoryID, RatingID, LevelID, Duration) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, quiz.getQuizContent());
            ps.setString(2, quiz.getQuizDescription());
            ps.setInt(3, 1);            
            ps.setInt(4, 4);
            ps.setInt(5, 1);
            ps.setInt(6, quiz.getDuration());
            int affectedRow = ps.executeUpdate();
            if(affectedRow > 0 ) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
