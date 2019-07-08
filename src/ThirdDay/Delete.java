package ThirdDay;

import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {

        /*String[] student = {"henry","yoeaki","name"};*/

        /*delect(student,"name");*/
        //创建一个数组
        String[] student = new String[6];

        //创建一个键盘输入对象
        Scanner sc = new Scanner(System.in);

        while (true){
            //提示输入信息
            System.out.println("0：添加，1：删除，2：查询，3：退出");

            //输入要执行的内容
            int condition = sc.nextInt();

            switch (condition){
                case 0:
                    sc.nextLine();
                    String name = sc.nextLine();
                    new Expansion().expansion(student,name);
                    break;
                case 1:
                    sc.nextLine();
                    String deleteName = sc.nextLine();
                    delete(student,deleteName);
                    break;
                case 2:
                    for (int i = 0; i < student.length; i++) {
                        if (student[i] != null){
                            System.out.println(student[i]);
                        }
                    }
                    break;
                default:
                    return;
            }
        }
    }

    public static void delete(String[] student,String name){

        int index = -1;

        if (student[0] == null){
            System.out.println("还没有学生，请录入！");
        }else {
            //找到下标
            for (int i = 0; i < student.length; i++) {
                if (student[i] != null){
                    if (name.equals(student[i])){
                        index = i;
                        break;
                    }
                }
            }

            for (int i = index; i < student.length; i++) {
                if (i < student.length - 1){
                    student[i] = student[i+1];
                }
                if (i == student.length - 1){
                    student[i] = null;
                }
            }

            /*for (int i = 0; i < student.length-1 ; i++) {
                if (student[i].equals(student[i+1]) && student[i] != null){
                    student[i+1] = null;
                }
            }*/

            for (int i = 0; i < student.length; i++) {
                if (student[i] != null)
                    System.out.println(student[i]);
            }
        }
    }

}
