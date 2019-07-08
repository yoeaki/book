package JDBCConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCHello {

    public static void main(String[] args) {

        List<Student> array = new ArrayList<>();

        //数据库语句/插入
        String insertUpdate = "insert into student(name,age,class) values('小龙',14,'医科五班')";
        PreparedStatement ps1 = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qf_shixun", "root", "root");
            System.out.println(connection);

            ps1 = connection.prepareStatement(insertUpdate);

            //执行数据库语句
            int row = ps1.executeUpdate();
            System.out.println("影响条数:" + row);

            //查询
            //查找所有信息
            String findAll = "select * from student";

            //预处理对象
            PreparedStatement findPs = connection.prepareStatement(findAll);
            ResultSet resultSet = findPs.executeQuery(findAll);

            while (resultSet.next()){
                array.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("class")));
            }

            for (Student arr:
                 array) {
                System.out.println(arr.toString());
            }

            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
