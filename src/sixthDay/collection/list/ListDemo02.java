package sixthDay.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo02 {

    public static void main(String[] args) {
        /**
         *
         * 增强for循环只负责取，不支持删除，删除会出现异常
         * 解决方案：删除成功后，直接跳出循环，break
         *
         * */

        List list = new ArrayList();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String ele = "A";

        /*for (int i = 0; i < list.size(); i++) {

            String str = list.get(i).toString();
            if (str.equals(ele)){
                list.remove(ele);
            }
        }*/

       /* for (Object object:
             list) {
            if (object.toString().equals(ele)){
                list.remove(ele);
            }
        }*/
        Iterator iterator = list.iterator();

        //删除后再添加
        while (iterator.hasNext()){
            if (iterator.next().toString().equals(ele)){
                list.add("D");
                list.remove(ele);
            }
        }

        //迭代器输出
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        /*System.out.println(list.size());*/
    }
}
