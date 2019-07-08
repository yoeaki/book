package ninthDay.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operation {
    static final String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
    static final String user = "root";
    static final String password = "root";
    Connection connection = null;
    PreparedStatement prst = null;

    public void connect() throws SQLException, ClassNotFoundException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void prst(String sql) throws SQLException {
        this.prst = connection.prepareStatement(sql);
    }

    public void releaseResources(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (prst != null) {
            try {
                prst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
