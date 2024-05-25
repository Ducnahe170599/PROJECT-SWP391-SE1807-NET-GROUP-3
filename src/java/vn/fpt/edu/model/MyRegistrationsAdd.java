/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.model;

/**
 *
 * @author nguye
 */
public class MyRegistrationsAdd {
    private int UserID;
    private String Email;   
    private int CategoryID;
    private int PackageID;
    private float total_cost;
    private int status;
    private String valid_from;
    private String valid_to;
    private String create_at;    

    public MyRegistrationsAdd(int UserID, String Email, int CategoryID, int PackageID, float total_cost, int status, String valid_from, String valid_to, String create_at) {
        this.UserID = UserID;
        this.Email = Email;
        this.CategoryID = CategoryID;
        this.PackageID = PackageID;
        this.total_cost = total_cost;
        this.status = status;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
        this.create_at = create_at;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
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

    public String getValid_from() {
        return valid_from;
    }

    public void setValid_from(String valid_from) {
        this.valid_from = valid_from;
    }

    public String getValid_to() {
        return valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    
}
