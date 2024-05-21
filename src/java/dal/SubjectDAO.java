package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author Admin
 */
public class SubjectDAO extends DBContext {

    /**
     * @param args the command line arguments
     * @return
     */
    /*----------- 
    Admin 
------------*/
    public List<Subject> getAllSubject() {
        List<Subject> list = new ArrayList<>();

        try {
            String sql = "SELECT \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image,\n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName,\n"
                    + "    COUNT(Lessons.LessonId) AS NumberOfLessons\n"
                    + "FROM \n"
                    + "    Subject\n"
                    + "LEFT JOIN \n"
                    + "    Lessons ON Subject.SubjectID = Lessons.LessonId\n"
                    + "JOIN \n"
                    + "    Package ON Package.PackageID = Subject.PackageId\n"
                    + "JOIN \n"
                    + "    Category ON Category.CategoryID = Subject.CategoryId\n"
                    + "JOIN \n"
                    + "    [User] ON [User].UserID = Subject.UserId\n"
                    + "JOIN \n"
                    + "    Ratings ON Ratings.RatingID = Subject.RatingID\n"
                    + "GROUP BY \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image, \n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName;";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getString(10),
                        rs.getInt(11));
                list.add(subject);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Subject> searchByName(String txtSearch) {
        List<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image,\n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName,\n"
                    + "    COUNT(Lessons.LessonId) AS NumberOfLessons\n"
                    + "FROM\n"
                    + "    Subject\n"
                    + "LEFT JOIN \n"
                    + "    Lessons ON Subject.SubjectID = Lessons.LessonId\n"
                    + "JOIN \n"
                    + "    Package ON Package.PackageID = Subject.PackageId\n"
                    + "JOIN \n"
                    + "    Category ON Category.CategoryID = Subject.CategoryId\n"
                    + "JOIN \n"
                    + "    [User] ON [User].UserID = Subject.UserId\n"
                    + "JOIN \n"
                    + "    Ratings ON Ratings.RatingID = Subject.RatingID\n"
                    + "WHERE Subject_Name LIKE ?\n"
                    + "GROUP BY \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image, \n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + txtSearch + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getString(10),
                        rs.getInt(11));
                list.add(subject);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Subject> getCategoryById(int id) {
        List<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image,\n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName,\n"
                    + "    COUNT(Lessons.LessonId) AS NumberOfLessons\n"
                    + "FROM\n"
                    + "    Subject\n"
                    + "LEFT JOIN \n"
                    + "    Lessons ON Subject.SubjectID = Lessons.LessonId\n"
                    + "JOIN \n"
                    + "    Package ON Package.PackageID = Subject.PackageId\n"
                    + "JOIN \n"
                    + "    Category ON Category.CategoryID = Subject.CategoryId\n"
                    + "JOIN \n"
                    + "    [User] ON [User].UserID = Subject.UserId\n"
                    + "JOIN \n"
                    + "    Ratings ON Ratings.RatingID = Subject.RatingID\n"
                    + "WHERE Category.CategoryID = ?\n"
                    + "GROUP BY \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image, \n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getString(10),
                        rs.getInt(11));
                list.add(subject);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Subject> getPackageById(int id) {
        List<Subject> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image,\n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName,\n"
                    + "    COUNT(Lessons.LessonId) AS NumberOfLessons\n"
                    + "FROM\n"
                    + "    Subject\n"
                    + "LEFT JOIN \n"
                    + "    Lessons ON Subject.SubjectID = Lessons.LessonId\n"
                    + "JOIN \n"
                    + "    Package ON Package.PackageID = Subject.PackageId\n"
                    + "JOIN \n"
                    + "    Category ON Category.CategoryID = Subject.CategoryId\n"
                    + "JOIN \n"
                    + "    [User] ON [User].UserID = Subject.UserId\n"
                    + "JOIN \n"
                    + "    Ratings ON Ratings.RatingID = Subject.RatingID\n"
                    + "WHERE Package.PackageID = ?\n"
                    + "GROUP BY \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image, \n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getString(10),
                        rs.getInt(11));
                list.add(subject);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int getTotalSubject() {
        String sql = "SELECT COUNT(*) FROM Subject";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1); // total 156
            }
        } catch (SQLException e) {
        }

        return 0;
    }

    public void insert(Subject subject) {
        String sql = "INSERT INTO [dbo].[Subject] (Subject_Name, Description, Image, PackageId, CategoryId, UserId, RatingID, Created_at) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, subject.getName());
            st.setString(2, subject.getDescription());
            st.setString(3, subject.getImage());
            st.setInt(4, subject.getPackageId());
            st.setInt(5, subject.getCategoryId());
            st.setInt(6, subject.getUserId());
            st.setInt(7, subject.getRatingId());
            st.setDate(8, new java.sql.Date(subject.getDate().getTime()));
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting into database: " + e.getMessage());
        }
    }

    public List<Subject> getSubjectsByCategoryAndPackage(int cateid, int packid) {
        List<Subject> list = new ArrayList<>();

        try {
            String sql = "SELECT \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image,\n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    COUNT(Lessons.LessonId) AS NumberOfLessons\n"
                    + "FROM \n"
                    + "    Subject\n"
                    + "LEFT JOIN \n"
                    + "    Lessons ON Subject.SubjectID = Lessons.LessonId\n"
                    + "JOIN \n"
                    + "    Package ON Package.PackageID = Subject.PackageId\n"
                    + "JOIN \n"
                    + "    Category ON Category.CategoryID = Subject.CategoryId\n"
                    + "JOIN \n"
                    + "    [User] ON [User].UserID = Subject.UserId\n"
                    + "JOIN \n"
                    + "    Ratings ON Ratings.RatingID = Subject.RatingID\n"
                    + "WHERE Subject.CategoryId = ? AND Subject.PackageId = ?\n"
                    + "GROUP BY \n"
                    + "    Subject.SubjectID, \n"
                    + "    Subject.Subject_Name, \n"
                    + "    Subject.Description, \n"
                    + "    Subject.Image, \n"
                    + "    Package.PackageName, \n"
                    + "    Category.Category_Name, \n"
                    + "    [User].UserName, \n"
                    + "    Ratings.Rating, \n"
                    + "    Subject.Created_at,\n"
                    + "    Lessons.LessonName;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, cateid);
            pst.setInt(2, packid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getInt(10));
                list.add(subject);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public Subject deleteSubject(int id) {
        String sql = "DELETE FROM Subject WHERE SubjectID = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String args[]) {
        // TODO code application logic here
        SubjectDAO sdao = new SubjectDAO();
//        for (Subject subject : list) {
//            System.out.println(subject);
//        }
//        int countSearch = sdao.countSearch("s");
//        System.out.println(countSearch);
        // Insert a new subject
//        Subject subject = new Subject("chinhpx", "good", "image2", 2, 1, 2, 2, Date.valueOf("2024-05-19"));
//        sdao.insert(subject);

//        int cate = sdao.getPackageIdByName("Basic Package");
//        System.out.println(cate);
//        List<Subject> lists = sdao.getSubjectsByCategoryAndPackage(3, 3);
//        for (Subject list : lists) {
//            System.out.println(list);
//        }
//        int totalSubject = sdao.getTotalSubject();
//        System.out.println(totalSubject);
//          Subject s = sdao.deleteSubject(9);
//          System.out.println(s);
    }

}
