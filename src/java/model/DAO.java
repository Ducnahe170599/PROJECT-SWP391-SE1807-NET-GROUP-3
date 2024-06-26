/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import vn.fpt.edu.Models.User;
//import vn.fpt.edu.Models.UserRole;
import dal.DBContext;
import java.util.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class DAO extends DBContext{

    private Connection con;
    private List<User> users;
    private List<UserRole> usRole;
    private String status = "OK";
    public static DAO INS = new DAO(); // INSTALL

//    private DAO() {
//        if(INS == null)
//        try {
//            con = new DBContext().connection;
//        } catch (Exception e) {
//            status = "Error at connection" + e.getMessage();
//        }
//        else INS = this;
//    }

    public void LoadAll() {
        users = new Vector<User>();
        String sql = "select * from Users";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String userName = rs.getString(3);
                java.sql.Date dbo = rs.getDate(4);
                String email = rs.getString(5);
                String password = rs.getString(6);
                String phone = rs.getString(7);
                String add = rs.getString(8);
                boolean gender = rs.getBoolean(9);
                int roleId = rs.getInt(10);
                String avatar = rs.getString(11);
                java.sql.Date createAt = rs.getDate(12);
                users.add(new User(id, fullName, userName, dbo, email, password, phone, add, gender, roleId, avatar, createAt));
            }
        } catch (Exception e) {
            status = "Error at red Student" + e.getMessage();
        }

        usRole = new Vector<UserRole>();
        sql = "select * from Roles";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usRole.add(new UserRole(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            status = "Error at red Department" + e.getMessage();
        }
    }

    public String getRoleName(int id) {
        for (UserRole role : usRole) {
            if (role.getRoleId()==id) {
                return role.getRoleName();
            }
        }
        return null;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> us) {
        this.users = us;
    }

    public List<UserRole> getUsRole() {
        return usRole;
    }

    public void setUsRole(List<UserRole> dept) {
        this.usRole = dept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void CreateAcc( String fullName, String userName, java.sql.Date dob, String email, String password, 
                String phone, java.sql.Date createAt) {
        String sql = "Insert into Users values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(2, fullName);
            ps.setString(3, userName);
            ps.setDate(4, dob);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, phone);
            
            ps.setDate(12, createAt);
            ps.execute();

        } catch (Exception e) {
            status = "Error at inssert student" + e.getMessage();
        }
    }

    public void Insert( String fullName, String userName, java.sql.Date dob, String email, String password, 
                String phone, String address, boolean gender, int roleId, String avatar, java.sql.Date createAt) {
        String sql = "Insert into Users values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(2, fullName);
            ps.setString(3, userName);
            ps.setDate(4, dob);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, phone);
            ps.setString(8, address);
            ps.setBoolean(9, gender);
            ps.setInt(10, roleId);
            ps.setString(11, avatar);
            ps.setDate(12, createAt);
            ps.execute();

        } catch (Exception e) {
            status = "Error at inssert student" + e.getMessage();
        }
    }

    public void Update(String id, String name, boolean gender,
            String departId, int age, float gpa,
            String add, String img, String dob) {
        String updateQuery = "UPDATE [dbo].[Student]\n"
                + "   SET \n"
                + "      [Name] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[DepartId] = ?\n"
                + "      ,[Age] = ?\n"
                + "      ,[Gpa] = ?\n"
                + "      ,[Add] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[dob] = ?\n"
                + " WHERE [Id]=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(9, id);
            ps.setString(1, name);
            ps.setString(3, departId);
            ps.setString(6, add);
            ps.setString(7, img);
            ps.setString(8, dob);
            ps.setBoolean(2, gender);
            ps.setInt(4, age);
            ps.setFloat(5, gpa);

            ps.execute();

        } catch (Exception e) {
            status = "Error at update student" + e.getMessage();
        }
    }

    public void Delete(String string) {
        String deletequery = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE Id= ?";
        try {
            PreparedStatement ps = con.prepareStatement(deletequery);
            ps.setString(1, string);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at delete student" + e.getMessage();
        }

    }

//    public void Delete(String id) {
//        String sql="delete  from Student\n" +
//                      "where Id = ?";
//        try {
//            con = new DBContext().getConnection();
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setString(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
}

class Using {

    public static void main(String[] args) {
        DAO d = DAO.INS;
        d.LoadAll();
        for (User us : d.getUser()) {
            System.out.println(us);
        }
    }
}
