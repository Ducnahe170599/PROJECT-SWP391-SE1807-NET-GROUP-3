/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vn.fpt.edu.model;
/**
 *
 * @author nguye
 */
public class UserEnrollAdd {
    private int enrollID;
    private int userID;
    private int subjectID;
    private int PakageID;
    private String Enroll_Date;
    private String ValidFrom;
    private String ValidTo;

    public UserEnrollAdd(int enrollID, int userID, int subjectID, int PakageID, String Enroll_Date, String ValidFrom, String ValidTo) {
        this.enrollID = enrollID;
        this.userID = userID;
        this.subjectID = subjectID;
        this.PakageID = PakageID;
        this.Enroll_Date = Enroll_Date;
        this.ValidFrom = ValidFrom;
        this.ValidTo = ValidTo;
    }

    public int getEnrollID() {
        return enrollID;
    }

    public void setEnrollID(int enrollID) {
        this.enrollID = enrollID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getPakageID() {
        return PakageID;
    }

    public void setPakageID(int PakageID) {
        this.PakageID = PakageID;
    }

    public String getEnroll_Date() {
        return Enroll_Date;
    }

    public void setEnroll_Date(String Enroll_Date) {
        this.Enroll_Date = Enroll_Date;
    }

    public String getValidFrom() {
        return ValidFrom;
    }

    public void setValidFrom(String ValidFrom) {
        this.ValidFrom = ValidFrom;
    }

    public String getValidTo() {
        return ValidTo;
    }

    public void setValidTo(String ValidTo) {
        this.ValidTo = ValidTo;
    }
    
}
