package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*Operation operation = new Operation();
        operation.connect();*/

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qf_shixun?useUnicode=true&characterEncoding=utf-8", "root", "root");

        String sql = "update student set name = ?,age = ? where id = ?";

        PreparedStatement prst = connection.prepareStatement(sql);

        prst.setString(1,"李白");
        prst.setInt(2,199);
        prst.setInt(3,1);

        int row = prst.executeUpdate();

        System.out.println(row);

    }
}
