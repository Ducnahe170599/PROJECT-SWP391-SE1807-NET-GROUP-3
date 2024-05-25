/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.DAO;


import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vn.fpt.edu.dal.DBContext;
import vn.fpt.edu.model.RegistrationsAdd;
import vn.fpt.edu.model.UserAdd;
import vn.fpt.edu.model.PackageAdd;
import vn.fpt.edu.model.SubjectAdd;





/**
 *
 * @author nguye
 */
public class RegistrationsDBContext extends DBContext{

    public ArrayList<RegistrationsAdd> getAllRegistrations() {
        ArrayList<RegistrationsAdd> list = new ArrayList<>();
        try {
            String sql = "select * from Registrations";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RegistrationsAdd(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getFloat(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("getAllRegistration Error!");
        }
        return list;
    }
    
     public ArrayList<UserAdd> getAllUser() {
        ArrayList<UserAdd> GetUser = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GetUser.add(new UserAdd(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12)
                        ));
            }
        } catch (SQLException e) {
            System.out.println("getAllUser Error!");
        }
        return GetUser;
    }
     public ArrayList<PackageAdd> getAllPackages() {
        ArrayList<PackageAdd> PackageAdd = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PackageAdd.add(new PackageAdd(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("getAllUser Error!");
        }
        return PackageAdd;
    }
     public ArrayList<SubjectAdd> getAllSubjects() {
        ArrayList<SubjectAdd> list = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SubjectAdd(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            System.out.println("getAllUser Error!");
        }
        return list;
    }
      public ArrayList<OrderandProductandAccount> getOderByUsernameID(int id){
        ArrayList<OrderandProductandAccount> list=new ArrayList<>();
        try {
            String sql="s";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new OrderandProductandAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));

            }
        } catch (SQLException e) {
            System.out.println("Loi o OrderandProductandAccount");
        }
        return list;
    }
     
   
}
