package day0712practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForAndIterator {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();

        for (int i = 0 ; i<1000000; i++){
            list.add(i);
        }
        long forNowTime = System.currentTimeMillis();
        for (Integer integer:list){
            System.out.print(integer);
        }
        long forEndTime = System.currentTimeMillis();
        System.out.println("增强for循环运行所用的时间：" + (forEndTime - forNowTime));

        System.out.println("==============================================");

        long iteratorNowTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        long iteratotEndTime = System.currentTimeMillis();
        System.out.println("Iteratot循环运行所用的时间：" + (iteratotEndTime - iteratorNowTime));

    }

}
