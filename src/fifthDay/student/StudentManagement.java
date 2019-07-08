package fifthDay.student;

import java.util.Scanner;

public class StudentManagement {

    static Student[] array = new Student[1];
    static Scanner sc = new Scanner(System.in);
    static Student st1 = new Student("Henry",18,"男","187752667270",01,187.00);
    static Student st2 = new Student("admin",18,"男","187752667270",01,187.00);
    static Student st3 = new Student("lady",18,"男","187752667270",01,187.00);
    public static void main(String[] args) {
        Array  arr = new Array();

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
                    }

                    break;
                case 3:
                    System.out.println("请输入要删除的学生：");
                    String removeName = sc.next();

                    remove(removeName);
                    break;
                case 4:
                    if (getSize() == 0){
                        System.out.println("该系统还没有学生，请录入！");
                    }else {
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] != null){
                                System.out.println(array[i]);
                            }
                        }
                    }
                    break;
                    case 5:
                        /*System.out.println("请输入自动录入的学生个数：");
                        int num = sc.nextInt();
                        String name = "admin";
                        int age = 18;
                        String sex = "男";
                        String phone = "18775266727";
                        Double weight = 108.00;
                        Integer num = 01;*/
                        add(st1);
                        add(st2);
                        add(st3);
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

        int index = get(student.getName());

        boolean exit = isEixt(student.getName());

        if (index == -1){
            int pos = -1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == null){
                    pos = i;
                    break;
                }
            }

            if (pos == -1){
                Student[] newArray = new Student[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
                /*add(student);*/
            }

            array[getSize()] = student;
        }

    }

    public static boolean isEixt(String name){

        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null){
                if (array[i].getName().equals(name)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
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
            array[index] = inputInfo(name);
        }else {
            System.out.println("不存在【"+ name +"】");
        }

    }

    public static void remove(String name){
        int index = get(name);
        int size = getSize();

        if(index == -1){
            System.out.println("该学生【"+ name +"】不存在！");
        }else {
            String ret = array[index].getName();
            for (int i = index + 1; i < size; i++) {
                array[i-1] = array[i];
            }
            array[size-1] = null;
            System.out.println("成功删除【"+ ret +"】学生");
        }
    }

    public static int get(String name){
        int index = -1;
        int size = getSize();
        for (int i = 0; i < size; i++) {
                if (array[i].getName().equals(name)){
                    index = i;
            }
        }
        /*array[size] = null;*/
        return index;
    }

    public static int getSize(){
        int size = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null){
                size++;
            }
        }
        return size;
    }



}
