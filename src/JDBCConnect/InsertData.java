package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static void main(String[] args) {

        Operation op = new Operation();

        try {
            op.connect();
            String sql = "insert student(name,age,class) values(?,?,?)";
            op.prst(sql);
            op.prst.setObject(1,"袁熙龙");
            op.prst.setObject(2,18);
            op.prst.setObject(3,"软件Q168");
            int row= op.prst.executeUpdate();
            System.out.println(row);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            op.releaseResources();
        }


    }
}
