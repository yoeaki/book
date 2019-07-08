package seventh.setDemo;

import sixthDay.student.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        /**
         * set的使用
         *
         * */
        //创建set集合
        Set set = new HashSet();

        //添加
        /*set.add("ABC");
        set.add(123);
        set.add("爱你");
        set.add(true);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("是否包含了该对象：" + set.contains("爱你"));

        boolean remove = set.remove(true);

        set.clear();

        System.out.println(set.isEmpty());*/

        Student student1 = new Student("admin", 18, "男", "1234567", 01, 174.1);
        Student student2 = new Student("Henry", 18, "男", "1234567", 01, 174.1);
        Student student3 = new Student("admin", 18, "男", "1234567", 01, 174.1);

        set.add(student1);
        set.add(student2);
        set.add(student3);

        Iterator iterator1 = set.iterator();

        Integer i =0;

        //在一个进程中
        System.out.println("第一次"+ i + iterator1.next());
        while (iterator1.hasNext()){
            i++;
            System.out.println("第一次"+ i + iterator1.next());

        }

        set.add("jfjdks");
        //迭代器记录着一个单独的个体，在迭代后，若再添加，应该再新建迭代器。
        Iterator iterator3 = set.iterator();
        System.out.println("第三次"+ i + iterator3.next());

    }
}
