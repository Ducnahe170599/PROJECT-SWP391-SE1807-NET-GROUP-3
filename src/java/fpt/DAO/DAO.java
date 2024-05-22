/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import fpt_model.FPT_UserEnoll;




/**
 *
 * @author nguye
 */

public class DAO {

    public void getAllEnrollments() throws SQLException {
        String sql = "SELECT * FROM Enrollment"; 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection(); 
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
  
                int enrollID = resultSet.getInt("enrollID");

            }
        } catch (SQLException e) {
            throw e; 
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
               
            }
            closeConnection(connection);
        }
    }

    private Connection getConnection() throws SQLException {
        
    }

    private void closeConnection(Connection connection) throws SQLException {
        
    }
}

                  


