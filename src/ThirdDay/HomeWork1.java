package ThirdDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {

        /**
         * 1.把数组中的值相加求和，平均值
         * 2.求最大值
         * 3.求最小值
         * 4.在数组中查找指定的元素
         * 5.往数组中添加元素
         * 6.数组的扩容
         * 7.数组的排序
         * */

        //创建Method对象
        Method method = new Method();

        //创建一个输入对象
        Scanner sc = new Scanner(System.in);

        //创建一个新数组
        int[] arr = {45,154,848,612,1,25,56};

        //创建一个空数组，进行测试
        int[] a = new int[10];
        System.out.println(a);

        //求数组中的最大值
        int max = method.getMax(arr);
        System.out.println(max);

        //求数组中的最小值
        int min = method.getMin(arr);
        System.out.println(min);

        //查找指定元素，看是否存在数组中，
        method.findByNum(arr,1);




        while (true){

            System.out.println("请输入对应数字，继续输入：0，停止输入：其它");

            int condition = sc.nextInt();
            switch (condition){
                case 0:
                    int number = sc.nextInt();
                    //添加元素和扩容
                    int[] list = method.add(arr,number);

                    //覆盖
                    arr = list;
                    //排序/升序
                    method.sort(arr);
                    for (int l : arr){
                        System.out.println(l);
                    }
                    break;
                 default:
                    System.out.println("停止输入成功！");
                    return;
            }

        }
    }
}
