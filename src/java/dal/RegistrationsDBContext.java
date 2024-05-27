package dal;


import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationsDBContext extends DBContext {


      
    public List<RegistrationsAdd> getAllRegistrations() {
        List<RegistrationsAdd> registrations = new ArrayList<>();
        String sql = "SELECT RegisterID, UserID, SubjectID, PackageID, total_cost, status, valid_from, valid_to, create_at FROM Registrations";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RegistrationsAdd registration = new RegistrationsAdd(
                    resultSet.getInt("RegisterID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("SubjectID"),
                    resultSet.getInt("PackageID"),
                    resultSet.getBigDecimal("total_cost"),
                    resultSet.getInt("status"),
                    resultSet.getDate("valid_from"),
                    resultSet.getDate("valid_to"),
                    resultSet.getTimestamp("create_at")
                );
                registrations.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }

    public void deleteRegistration(int registerID) {
        String sql = "DELETE FROM Registrations WHERE RegisterID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, registerID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserAdd> getAllUser() {
        ArrayList<UserAdd> GetUser = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Users";
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
            e.printStackTrace();
        }
        return GetUser;
    }

    public ArrayList<PackageAdd> getAllPackages() {
        ArrayList<PackageAdd> PackageAdd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Packages";
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
            e.printStackTrace();
        }
        return PackageAdd;
    }

    public ArrayList<SubjectAdd> getAllSubjects() {
        ArrayList<SubjectAdd> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Subjects";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SubjectAdd(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getTimestamp(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CategoriesAdd> getAllCategories() {
        ArrayList<CategoriesAdd> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoriesAdd(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MyRegistrationsAdd> getRegistrationDetails(int userId) {
        List<MyRegistrationsAdd> registrationDetails = new ArrayList<>();
        try {
            String sql = "SELECT "
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
                + "JOIN Package ON Registration.packageID = Package.packageID "
                + "WHERE Users.userID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationDetails;
    }
    
}
