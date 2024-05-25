/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author nguye
 */
public class RegistrationsAdd {

    private int RegisterID;
    private int UserID;
    private int SubjectID;
    private int PackageID;
    private float total_cost;
    private int status;
    private Date valid_from;
    private Date valid_to;
    private Timestamp  create_at;    

    public RegistrationsAdd(int RegisterID, int UserID, int SubjectID, int PackageID, float total_cost, int status, Date valid_from, Date valid_to, Timestamp create_at) {
        this.RegisterID = RegisterID;
        this.UserID = UserID;
        this.SubjectID = SubjectID;
        this.PackageID = PackageID;
        this.total_cost = total_cost;
        this.status = status;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
        this.create_at = create_at;
    }

    public int getRegisterID() {
        return RegisterID;
    }

    public void setRegisterID(int RegisterID) {
        this.RegisterID = RegisterID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public int getPackageID() {
        return PackageID;
    }

    public void setPackageID(int PackageID) {
        this.PackageID = PackageID;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public Date getValid_to() {
        return valid_to;
    }

    public void setValid_to(Date valid_to) {
        this.valid_to = valid_to;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

}
