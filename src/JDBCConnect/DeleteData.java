package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement prst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qf_shixun", "root", "root");

            String sql = "delete from student where id = ?";
            prst = connection.prepareStatement(sql);

            prst.setInt(1,9);

            int row = prst.executeUpdate();

            System.out.println(row);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
