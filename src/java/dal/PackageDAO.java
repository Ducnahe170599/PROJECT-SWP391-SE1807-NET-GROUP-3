package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Packages;

/**
 *
 * @author Admin
 */
public class PackageDAO extends DBContext {

    /**
     * @param args the command line arguments
     */
    public List<Packages> getAllPackage() {
        List<Packages> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Packages";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Packages p = new Packages(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String args[]) {
        // TODO code application logic here
        PackageDAO pdao = new PackageDAO();
        List<Packages> listp = pdao.getAllPackage();
        for (Packages packages : listp) {
            System.out.println(packages);
        }
    }
}
