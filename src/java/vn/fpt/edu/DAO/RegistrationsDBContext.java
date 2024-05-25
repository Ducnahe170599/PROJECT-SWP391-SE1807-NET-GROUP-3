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
import vn.fpt.edu.model.CategoriesAdd;
import vn.fpt.edu.model.MyRegistrationsAdd;
import vn.fpt.edu.model.RegistrationsAdd;
import vn.fpt.edu.model.UserAdd;
import vn.fpt.edu.model.PackageAdd;
import vn.fpt.edu.model.SubjectAdd;
import java.util.List;

/**
 *
 * @author nguye
 */
public class RegistrationsDBContext extends DBContext {

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
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getTimestamp(9)));
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
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getTimestamp(12)
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
                        rs.getTimestamp(6)));
            }
        } catch (SQLException e) {
            System.out.println("getAllUser Error!");
        }
        return list;
    }

    public ArrayList<CategoriesAdd> getAllCategories() {
        ArrayList<CategoriesAdd> list = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoriesAdd(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("getAllUser Error!");
        }
        return list;
    }

    public List<MyRegistrationsAdd> getRegistrationDetails() throws SQLException {
        List<MyRegistrationsAdd> registrationDetails = new ArrayList<>();
        try {String sql = "SELECT "
                + "Users.userID, "
                + "Users.email, "
                + "Subject.subjectID, "
                + "Package.packageID, "
                + "Registration.userID, "
                + "Registration.email, "
                + "Registration.subjectID, "
                + "Registration.packageID, "
                + "Registration.total_cost, "
                + "Registration.status, "
                + "Registration.valid_from, "
                + "Registration.valid_to, "
                + "Registration.create_at "
                + "FROM "
                + "Users "
                + "JOIN Registration ON Users.userID = Registration.userID "
                + "JOIN Subject ON Registration.subjectID = Subject.subjectID "
                + "JOIN Package ON Registration.packageID = Package.packageID"; 
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(); 
                while (rs.next()) {
                registrationDetails.add(new MyRegistrationsAdd(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getFloat(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getTimestamp(9)));
            }

        } catch (Exception e) {
            System.out.println("getRegistrationDetails error!");
        }
        return registrationDetails;
    }
}
