/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.fpt.edu.model.Category;

/**
 *
 * @author Datnt
 */
public class CategoryDAO extends DbContext {

    private Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public CategoryDAO() {
        try {
            con = new DbContext().getConnection();
            System.out.println("Connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> GetAllCategory() {
        String sql = "SELECT * FROM [Categories]";
        List<Category> listCategory = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategoryID(rs.getInt("CategoryID"));
                cate.setCategory_Name(rs.getString("category_name"));

                listCategory.add(cate);
            }
            return listCategory;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
