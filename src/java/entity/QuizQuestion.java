/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author minh1
 */
public class QuizQuestion {
    private int QzQuestionID ; 
    private String QuestionDetail ; 
    private int QuizId;

    public QuizQuestion() {
    }

    public QuizQuestion(int QzQuestionID, String QuestionDetail, int QuizId) {
        this.QzQuestionID = QzQuestionID;
        this.QuestionDetail = QuestionDetail;
        this.QuizId = QuizId;
    }

    public int getQzQuestionID() {
        return QzQuestionID;
    }

    public void setQzQuestionID(int QzQuestionID) {
        this.QzQuestionID = QzQuestionID;
    }

    public String getQuestionDetail() {
        return QuestionDetail;
    }

    public void setQuestionDetail(String QuestionDetail) {
        this.QuestionDetail = QuestionDetail;
    }

    public int getQuizId() {
        return QuizId;
    }

    public void setQuizId(int QuizId) {
        this.QuizId = QuizId;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" + "QzQuestionID=" + QzQuestionID + ", QuestionDetail=" + QuestionDetail + ", QuizId=" + QuizId + '}';
    }
    
}
