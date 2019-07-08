package ninthDay.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    static List<Student> list = new ArrayList<Student>();
    static Operation op = new Operation();
    static Scanner sc = new Scanner(System.in);
    static String man = "男";
    static String female = "女";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("欢迎来到学生管理系统");

        while (true){
            System.out.println("1.添加学生\n 2.修改学生\n 3.删除学生\n 4.查询学生\n 5.自动录入\n 6.退出系统");

            int condition = sc.nextInt();

            switch(condition){
                case 1:
                    System.out.println("请输入学生姓名！");
                    String name = sc.next();
                    if (get(name)!= -1){
                        System.out.println("该学生【" + name + "】已经存在，添加失败！");
                    }else {
                        //调用添加学生信息
                        add(inputInfo(name));
                    }
                    break;
                case 2:
                    System.out.println("请输入你要修改的学生姓名：");

                    String rename = sc.next();

                    if (get(rename) == -1){
                        System.out.println("该系统没有【" + rename + "】学生！");
                    }else {
                        update(rename);
                        System.out.println("修改成功！");
                    }

                    break;
                case 3:
                    System.out.println("请输入要删除的学生：");
                    String removeName = sc.next();

                    if (get(removeName) == -1){
                        System.out.println("该学生【"+removeName+"】不存在！");
                    }else {
                        remove(removeName);
                    }

                    break;
                case 4:
                    List<Student> getStudent = findAll();
                    for (Student s:getStudent){
                        System.out.println(s);
                    }
                    break;
                    case 5:

                        System.out.println("自动录入成功！");
                        break;
                default:
                    return;
            }
        }

    }
    /*public boolean isExit(String name){
        boolean flag = false;

        for (int i = 0; i < arr.)
    }*/

    public static void add(Student student) throws SQLException, ClassNotFoundException {
        Integer endSex = 0;
        if (female.equals(student.getSex())){
            endSex = 1;
        }
        op.connect();
        String sql = "insert into student (name,num,age,sex,phone,height) values(?,?,?,?,?,?)";
        op.prst(sql);
        op.prst.setString(1,student.getName());
        op.prst.setString(2,student.getNum());
        op.prst.setInt(3,student.getAge());
        op.prst.setInt(4,endSex);
        op.prst.setString(5,student.getPhone());
        op.prst.setDouble(6,student.getHeight());

        boolean execute = op.prst.execute();
        System.out.println("什么情况：" + execute);
    }


    public static Student inputInfo(String name){

        System.out.println("请输入学生学号！");
        String num = sc.next();
        System.out.println("请输入学生年龄！");
        Integer age = sc.nextInt();
        System.out.println("请输入学生性别！");
        String sex = sc.next();
        System.out.println("请输入学生号码！");
        String phone = sc.next();
        System.out.println("请输入学生体重！");
        Double weight = sc.nextDouble();
        return new Student(name,age,sex,phone,num,weight);
    }

    public static void update(String name){
        int index = 0;
        try {
            index = get(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (index != -1){
            Student student = inputInfo(name);
            list.set(index,student);
        }else {
            System.out.println("不存在【"+ name +"】");
        }

    }

    public static void remove(String name) throws SQLException, ClassNotFoundException {

        op.connect();
        String sql = "delete from student where name = ?";
        op.prst(sql);
        op.prst.setString(1,name);
        int row = op.prst.executeUpdate();
        System.out.println("删除了吗？：" + row);

    }

    public static int get(String name) throws SQLException, ClassNotFoundException {
        int index = -1;

        op.connect();
        String sql = "select * from student where name = ?";
        op.prst(sql);
        op.prst.setString(1,name);

        ResultSet resultSet = op.prst.executeQuery();
        if (resultSet.next()){
            index = 1;
        }
        return index;


        /*array[size] = null;*/
    }
    public static List<Student> findAll() throws SQLException, ClassNotFoundException {
        List<Student> getStudent = new ArrayList<>();
        op.connect();
        String sql = "select * from student";
        op.prst(sql);

        ResultSet resultSet = op.prst.executeQuery();

        if (!resultSet.next()){
            System.out.println("该系统暂时没有学生，请录入！");
        }
        while (resultSet.next()){
            String sex = "男";
            if (resultSet.getInt("sex") == 1){
                sex = "女";
            }
            getStudent.add(new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    sex,
                    resultSet.getString("phone"),
                    resultSet.getString("num"),
                    resultSet.getDouble("height")
                    ));
        }
        return getStudent;
    }




}
