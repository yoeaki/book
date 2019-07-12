package day07.test01.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LIstDemoMain {

    public static void main(String[] args) {

        /*
        * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
        *
        * */
        int[] arr = {1223,545,455};
        Map<String,Object> map = new HashMap(16);
        map.put("name","名字");
        Map<String,DemoTest> map2 = new HashMap(16);
        map2.put("demoTest",new DemoTest());

        ListDemo listDemo = new ListDemo();
        ListDemo obj = new ListDemo();
        listDemo.eat(obj);
        listDemo.eat(arr);
        listDemo.eat(1231);
        listDemo.eat("1231");
        listDemo.eat(true);
        listDemo.wildcard(map);
        listDemo.wildcard(map2);
        System.out.println("========================================");

        /*
        * 在new对象的时候确定泛型类型，那么该对象的类型就确定了
        * */
        ListDemo<String> listDemo2 = new ListDemo();
//      listDemo2.eat(1231);
        listDemo2.eat("1231");
//      listDemo2.eat(true);
        System.out.println("========================================");

        ListDemo listDemo3 = (ListDemo<String>)listDemo.run(123);
        listDemo3.eat("吃饭了");
    }
}
