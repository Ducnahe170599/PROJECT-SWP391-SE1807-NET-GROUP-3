/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

/**
 *
 * @author Datnt
 */
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Quiz {
    private int QuizId;
    private String QuizContent;
    private String QuizDescription;
    private String Image;
    private int CategoryId;
    private int Duration;
    private int RankingId;
    private int LevelId;
    private String CreateAt;

    public Quiz() {
    }

    public Quiz(int QuizId, String QuizContent, String QuizDescription, String Image, int CategoryId, int Duration, int RankingId, int LevelId, String CreateAt) {
        this.QuizId = QuizId;
        this.QuizContent = QuizContent;
        this.QuizDescription = QuizDescription;
        this.Image = Image;
        this.CategoryId = CategoryId;
        this.Duration = Duration;
        this.RankingId = RankingId;
        this.LevelId = LevelId;
        this.CreateAt = CreateAt;
    }

    public int getQuizId() {
        return QuizId;
    }

    public void setQuizId(int QuizId) {
        this.QuizId = QuizId;
    }

    public String getQuizContent() {
        return QuizContent;
    }

    public void setQuizContent(String QuizContent) {
        this.QuizContent = QuizContent;
    }

    public String getQuizDescription() {
        return QuizDescription;
    }

    public void setQuizDescription(String QuizDescription) {
        this.QuizDescription = QuizDescription;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public int getRankingId() {
        return RankingId;
    }

    public void setRankingId(int RankingId) {
        this.RankingId = RankingId;
    }

    public int getLevelId() {
        return LevelId;
    }

    public void setLevelId(int LevelId) {
        this.LevelId = LevelId;
    }

    public String getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(String CreateAt) {
        this.CreateAt = CreateAt;
    }

    @Override
    public String toString() {
        return "Quiz{" + "QuizId=" + QuizId + ", QuizContent=" + QuizContent + ", QuizDescription=" + QuizDescription + ", Image=" + Image + ", CategoryId=" + CategoryId + ", Duration=" + Duration + ", RankingId=" + RankingId + ", LevelId=" + LevelId + ", CreateAt=" + CreateAt + '}';
    }
}
