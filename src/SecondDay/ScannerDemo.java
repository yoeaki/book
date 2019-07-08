package SecondDay;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        /**
         * Scanner练习
         * */

/*        //创建Scanner对象
        Scanner sc = new Scanner(System.in);

        //输入int类型
        int intNum = sc.nextInt();

        //输入字符串类型
        String str = sc.nextLine();

        //输入double类型
        double douNum = sc.nextDouble();

        //输入sort类型
        short sortNum = sc.nextShort();

        //输入Long类型
        long longNum = sc.nextLong();

        //输入字节
        byte byteNum = sc.nextByte();

        System.out.println("int类型：" + intNum);
        System.out.println("String类型：" + str);
        System.out.println("double类型：" + douNum);
        System.out.println("short类型：" + sortNum);
        System.out.println("long类型：" + longNum);
        System.out.println("byte类型：" + byteNum);*/

        int[] arr = {1,2,34,4};
        for (int a:arr){
            System.out.println(a);
        }

        int[][] arr2 = {{1,2,3},{4,546,7},{45,45,465}};
        for (int[] a:arr2
             ) {
            System.out.println(a);
        }

        int[][][] arr3 = {{{1,2,45},{4,45,45}},{{12,47,79},{787,7846}}};
        for (int[][] a:arr3
             ) {
            System.out.println(a);
        }
    }
}
