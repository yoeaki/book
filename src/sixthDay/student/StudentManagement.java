package sixthDay.student;

import fifthDay.student.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    static List<Student> list = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);
    static Student st1 = new Student("Henry",18,"男","187752667270",01,187.00);
    static Student st2 = new Student("admin",18,"男","187752667270",01,187.00);
    static Student st3 = new Student("lady",18,"男","187752667270",01,187.00);
    public static void main(String[] args) {

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
                    }
                    remove(removeName);
                    break;
                case 4:
                    if (list.size() == 0){
                        System.out.println("该系统还没有学生，请录入！");
                    }else {
                        for (Student stu:
                             list) {
                            System.out.println(stu);
                        }
                    }
                    break;
                    case 5:

                        list.add(st1);
                        list.add(st1);
                        list.add(st1);
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

    public static void add(Student student){
        list.add(student);
    }


    public static Student inputInfo(String name){

        System.out.println("请输入学生学号！");
        Integer num = sc.nextInt();
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
        int index = get(name);
        if (index != -1){
            Student student = inputInfo(name);
            list.set(index,student);
        }else {
            System.out.println("不存在【"+ name +"】");
        }

    }

    public static void remove(String name){
        int index = get(name);

        Student remove = list.remove(index);
        System.out.println("恭喜你成功删除【"+ list.get(index).getName() +"】!");
    }

    public static int get(String name){
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                index = i;
            }
        }

        /*array[size] = null;*/
        return index;
    }




}
