package sixthDay.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListDemo {

    public static void main(String[] args) {

        //父类声明，子类实现
        List list = new ArrayList();

        list.add("前前");
        list.add("陈");
        list.add("前");
        list.add("前");
        /*list.remove(0);*/
        System.out.println("查找指定索引的值：" + list.get(0));
        System.out.println("查看集合中的长度：" + list.size());
        System.out.println("判断集合是否为空："+ list.isEmpty());
        /*list.clear();*/
        System.out.println("查看集合中是否包含该对象：" + list.contains("前"));
        /*list.subList(1,2);*/
        System.out.println("查看该对象所处的索引" + list.indexOf("前"));

        //将集合转为数组
        Object[] objects = list.toArray();
        //将指定位置的元素替换，返回被替换的元素

        for (int i = 0; i < 100000; i++) {
            list.add("陈前前" + i);
        }

        long start1 = System.currentTimeMillis();
        //获取迭代器对象
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(",");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("\nfor循环时间：" + (end1 - start1));

        System.out.println("===========");

        long start2 = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(",");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("\n迭代器时间：" + (end2 - start2));

        System.out.println("===========");

        long start3 = System.currentTimeMillis();
        for (Object l:
             list) {
            System.out.print(l);
            System.out.print(",");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("\n增强for循环时间：" + (end3 - start3));
    }
}
