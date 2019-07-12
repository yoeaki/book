package day07.test01.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListDemo<E> {

    private String str;
    private Integer num;

    /**
     *
     * @Description 传递泛型E类型参数，在创建对象时没有给定初始化类型时
     *              那么E可以传递任何类型，Object，Integer，String and many more.
     * @date 2019/7/9 11:34
     * @params [parameter]
     * @return void
     * @Exception
     */
    public void eat(E parameter){

        System.out.println("我的类型是：" + parameter.getClass());

    }

    public void wildcard(Map<?,?> obj){
        Iterator<?> iterator = obj.keySet().iterator();
        if (iterator.hasNext()){
            System.out.println("值：" + obj.get(iterator.next()));
        }
        System.out.println("通配符：" + obj.getClass()+ "   键：" + obj.keySet() + "   值：" + obj.get(obj.keySet()));
    }

    /**
     *
     * @Description 提前声明一个T类型，因为在类中没有任何地方声明，不声明编译不通过
     *              返回一个E泛型类型对象，为什么需要在new后需要转型呢？
     *                  1.因为new 的ListDemo<E>返回的是ListDemo类型并不是E类型（可看构造函数）
     *                  2.需要强转E类型。
     *                  3.再使用T泛型的好处是可以传递任何类型的变量。
     * @date 2019/7/9 11:28
     * @params [parameter]
     * @return E
     * @Exception
     */
    public <T> E run(T parameter){
        System.out.println("类型：" + parameter.getClass());
        return (E) new ListDemo<E>();
    }


    public ListDemo(String str, Integer num) {
        this.str = str;
        this.num = num;
    }
    public ListDemo() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
