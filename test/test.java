
import dal.QuestionDAO;
import entity.QuizQuestion;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minh1
 */
public class test {
    public static void main(String[] args) {
        QuestionDAO dao = new QuestionDAO();
        List<QuizQuestion> list = dao.getAllQuestion(); 
        for (QuizQuestion o : list){
            System.out.println(o);
        }
    }
}
