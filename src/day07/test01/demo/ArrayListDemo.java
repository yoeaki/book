package day07.test01.demo;


import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("21231");
        list.add(21231);

        try{
            for (int i = 0; i<list.size(); i++){
                String str = (String) list.get(i);
                System.out.println("输出结果：" + str);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        Class<? extends List> aClass = strings.getClass();
        Class<? extends List> aClass1 = integers.getClass();
        System.out.println(aClass==aClass1);
        System.out.println("equals是否为真：" + aClass.equals(aClass1));
    }
}
