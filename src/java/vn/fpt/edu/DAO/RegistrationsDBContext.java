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
    public 
}
