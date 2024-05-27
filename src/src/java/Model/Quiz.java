/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Datnt
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
