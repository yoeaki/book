package FirstDay;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonMain {

    public static void main(String[] args) {

        PersonDemo personDemo = new PersonDemo();

        Scanner sc = new Scanner(System.in);

        //用于存储学生信息
        List<PersonDemo> list = new ArrayList<>();


        while (true){
            System.out.println("请输入想要执行的操作：");
            System.out.println("0：继续输入，1：显示所有学生信息，2:根据学号删除学生信息，其他：退出");
            int expression = sc.nextInt();

            switch(expression){
                case 0 :
                    sc.nextLine();
                    System.out.println("请输入学生姓名：");
                    String name = sc.nextLine();
                    System.out.println("请输入学生性别：");
                    String sex = sc.nextLine();
                    System.out.println("请输入学生学号：");
                    String num = sc.nextLine();
                    System.out.println("请输入学生年龄：");
                    int    age = sc.nextInt();
                    System.out.println("请输入学生体重：");
                    double weight = sc.nextDouble();
                    System.out.println("请输入学生邮箱：");
                    sc.nextLine();
                    String email = sc.nextLine();

                    list.add(new PersonDemo(name,sex,num,age,weight,email));
                    break; //可选
                case 1 :

                    if (list.size() == 0) {
                        System.out.println("还没有学生信息！请按0输入");
                    }
                    else {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("第"+ i +"位学生：\n" + "姓名:" + list.get(i).getName()+
                                    "，性别:" + list.get(i).getSex()+
                                    "，学号:" + list.get(i).getNum()+
                                    "，年龄:" + list.get(i).getAge()+
                                    "，体重:" + list.get(i).getWeight()+
                                    "，邮箱:" + list.get(i).getEmail()
                            );
                        }
                    }
                    break;
                    case 2:
                        System.out.println("请输入学生学号：");
                        String removeNum = sc.nextLine();

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getNum() == removeNum){
                                //删除学号相等的学生
                                list.remove(i);
                            }else {
                                System.out.println("该学号不存在！");
                            }
                        }
                        break;
                    //可选
                //你可以有任意数量的case语句
                default : //可选
                    break;
            }
        }
    }
}
