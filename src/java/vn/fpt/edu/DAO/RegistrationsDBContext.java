/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.DAO;

import jakarta.servlet.Registration;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import vn.fpt.edu.dal.DBContext;
import vn.fpt.edu.model.RegistrationsAdd;
import java.sql.*;




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
   public List<Registration> FilterRegistrations(String email, String subject, String status, String dateFrom, String dateTo) {
        List<Registration> registrations = new ArrayList<>();
        String sql = "SELECT registration.RegisterID, users.email, registration.created_at, subjects.name AS subject_name, packages.name AS package_name, registration.total_cost, registration.status, registration.valid_from, registration.valid_to FROM registration JOIN users ON registration.UserID = users.id JOIN subjects ON registration.SubjectID = subjects.id JOIN packages ON registration.PackageID = packages.id WHERE (users.email LIKE ? OR ? IS NULL) AND (subjects.name LIKE ? OR ? IS NULL) AND (registration.status = ? OR ? IS NULL) AND (registration.created_at BETWEEN ? AND ? OR (? IS NULL AND ? IS NULL))";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email != null ? "%" + email + "%" : null);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, subject != null ? "%" + subject + "%" : null);
            preparedStatement.setString(4, subject);
            preparedStatement.setInt(5, status != null ? Integer.parseInt(status) : -1);
            preparedStatement.setInt(6, status != null ? Integer.parseInt(status) : -1);
            preparedStatement.setString(7, dateFrom);
            preparedStatement.setString(8, dateTo);
            preparedStatement.setString(9, dateFrom);
            preparedStatement.setString(10, dateTo);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RegisterID");
                String emailResult = rs.getString("email");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String subjectResult = rs.getString("subject_name");
                String packageName = rs.getString("package_name");
                BigDecimal totalCost = rs.getBigDecimal("total_cost");
                int statusResult = rs.getInt("status");
                Date validFrom = rs.getDate("valid_from");
                Date validTo = rs.getDate("valid_to");
                registrations.add(new Registrations(id, emailResult, createdAt, subjectResult, packageName, totalCost, statusResult, validFrom, validTo));
            }
        } catch (SQLException e) {
            System.out.println("FilterRegistration Error!");
        }
        return registrations;
    }
}
