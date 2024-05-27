/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vn.fpt.edu.model.Quiz;

/**
 *
 * @author ADMIN
 */
public class QuizDAO extends DbContext {

    private Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public QuizDAO() {
        try {
            con = new DbContext().getConnection();
            System.out.println("Connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Quiz> getListQuiz() {
        String sql = "SELECT * FROM [Quizzes]";
        List<Quiz> listQuiz = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizID(rs.getInt("QuizID"));
                quiz.setTitle(rs.getString("title"));
                quiz.setDescription(rs.getString("description"));
                quiz.setLevel(rs.getInt("Level"));
                quiz.setCategoryID(rs.getInt("CategoryID"));
                quiz.setSubjectID(rs.getInt("SubjectID"));
                quiz.setImage(rs.getString("Image"));
                quiz.setCreateAt(rs.getDate("created_at").toString());
                listQuiz.add(quiz);
            }
            return listQuiz;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     public Quiz getQuizById(int Id) {
        String sql = "SELECT * FROM [Quizzes] WHERE QuizID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizID(rs.getInt("QuizID"));
                quiz.setTitle(rs.getString("title"));
                quiz.setDescription(rs.getString("description"));
                quiz.setLevel(rs.getInt("Level"));
                quiz.setCategoryID(rs.getInt("CategoryID"));
                quiz.setSubjectID(rs.getInt("SubjectID"));
                quiz.setImage(rs.getString("Image"));
                quiz.setCreateAt(rs.getDate("created_at").toString());
                return quiz;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addNewQuiz(Quiz quiz) {
        String sql = "INSERT INTO Quizzes (title, Image,  description, Level, SubjectID, CategoryID, created_by, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, quiz.getTitle());
            ps.setString(2, "");
//            ps.setString(2, quiz.getImage());
            ps.setString(3, quiz.getDescription());
            ps.setInt(4, quiz.getLevel());
            ps.setInt(5, quiz.getSubjectID());
            ps.setInt(6, quiz.getCategoryID());

//            ps.setInt(7, quiz.getCreateById());//   
            ps.setInt(7, 3);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            ps.setObject(8, currentDate);
            int affectedRow = ps.executeUpdate();
            if (affectedRow > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
     public boolean updateQuiz(Quiz quiz) {
        String sql = "UPDATE  Quizzes SET  title = ? , Image = ?, description = ?, Level = ?, SubjectID = ?, CategoryID = ?, "
                + "created_by = ?, created_at = ? WHERE QuizID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, quiz.getTitle());
            ps.setString(2, "");
//            ps.setString(2, quiz.getImage());
            ps.setString(3, quiz.getDescription());
            ps.setInt(4, quiz.getLevel());
            ps.setInt(5, quiz.getSubjectID());
            ps.setInt(6, quiz.getCategoryID());

//            ps.setInt(7, quiz.getCreateById());//   
            ps.setInt(7, 3);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            ps.setObject(8, currentDate);    
            ps.setObject(9, quiz.getQuizID());

            int affectedRow = ps.executeUpdate();
            if (affectedRow > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
