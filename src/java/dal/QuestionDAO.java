/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import entity.QuizQuestion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author minh1
 */
public class QuestionDAO {
    Connection conn = null ; 
    PreparedStatement ps = null ; 
    ResultSet rs = null ; 
    public List<QuizQuestion> getAllQuestion(){
        List<QuizQuestion> list = new ArrayList<>(); 
        String query = "select * from QuizQuestions"; 
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new QuizQuestion(rs.getInt(1),rs.getString(2),rs.getInt(3)));
                
            }
        } catch (Exception e) {
        }
        
        
        return list ; 
    }
    public void insertQuestion(String qdetail , String quizid){
        String query = "INSERT INTO [dbo].[QuizQuestions]\n" +
"           \n" +
"     VALUES\n" +
"           (?,?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,  qdetail);
            ps.setString(2, quizid);
            ps.executeUpdate();   
        } catch (Exception e) {
        }
    }
    
    public void deleteQuestion(String id ){
        String query = "DELETE FROM [dbo].[QuizQuestions]\n" +
"      WHERE QzQuestionID = ?" ; 
        try {
             conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
