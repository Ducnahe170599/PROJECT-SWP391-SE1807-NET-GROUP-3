/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Timestamp;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class UserAdd {
    private int UserID;
    private String FullName;
    private String UserName;
    private Date DateOrBirth;
    private String Email;
    private String Password;
    private int Phone;
    private String Address;
    private int Gender;
    private int RoleID;
    private String Avatar;
    private Timestamp  Create_at;

    public UserAdd(int UserID, String FullName, String UserName, Date DateOrBirth, String Email, String Password, int Phone, String Address, int Gender, int RoleID, String Avatar, Timestamp Create_at) {
        this.UserID = UserID;
        this.FullName = FullName;
        this.UserName = UserName;
        this.DateOrBirth = DateOrBirth;
        this.Email = Email;
        this.Password = Password;
        this.Phone = Phone;
        this.Address = Address;
        this.Gender = Gender;
        this.RoleID = RoleID;
        this.Avatar = Avatar;
        this.Create_at = Create_at;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Date getDateOrBirth() {
        return DateOrBirth;
    }

    public void setDateOrBirth(Date DateOrBirth) {
        this.DateOrBirth = DateOrBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public Timestamp getCreate_at() {
        return Create_at;
    }

    public void setCreate_at(Timestamp Create_at) {
        this.Create_at = Create_at;
    }

    
}
