/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.DAO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fpt_model.FPT_UserEnoll;
import fpt_model.FPT_Roles;
import fpt_model.FPT_UserEnoll;
import fpt_model.FPT_User;


/**
 *
 * @author nguye
 */
public class DAO extends DBContext{

     public ArrayList<UserEnoll> getAllUserEnoll() {
        ArrayList<UserEnoll> list = new ArrayList<>();
        try {
            String sql = "select *from products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserEnoll(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
