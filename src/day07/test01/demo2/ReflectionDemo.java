package day07.test01.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //通过反射获取Student类
        Class<?> student = Class.forName("day07.test01.demo2.Student");
        //获取Student类的构造函数存进数组中
        Constructor<?>[] constructors = student.getConstructors();

        /**
        * 通过调用空构造函数（我的空构造函数写在第二个，所以索引是1）进行实例化对象
        * */
        Student student1  = (Student)constructors[1].newInstance();
        //给name赋值
        student1.setName("Henry");
        System.out.println(student1.toString());
        System.out.println("================================================");

        Student student2 = (Student) constructors[0].newInstance("陈前前","女",18);
        student2.setName("陈前前");
        System.out.println(student2.toString());
        System.out.println("================================================");

        /*String reflection = "day07.test01.demo.ListDemo";
        Object demo = Class.forName(reflection).newInstance();
        Method[] methods = demo.getClass().getMethods();
        for (int i = 0; i < methods.length; i++){
            System.out.println("成员变量：" + methods[i]);
        }
        System.out.println("=================");*/

        Student student3 = (Student) student.newInstance();
        student3.setName("yoeaki");
        student3.setAge(13);
        student3.setSex("男");
        Field[] fields2 = student.getDeclaredFields();
        Field[] fields = student3.getClass().getDeclaredFields();
        if (fields.length == 0){
            System.out.println("空");
        }
        for (int i = 0; i < fields.length; i++){
            
        }
    }
}
