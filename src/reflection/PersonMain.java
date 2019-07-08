package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PersonMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        /**
         * 反射
         *      通过反射获取类名的三种方式
         *          1.Class.forName("")
         *
         *
         *
         * */
        Class<Person> class1 = Person.class;


        Field[] fields = class1.getFields();
        System.out.println(fields);
        for (Field field:fields){
            System.out.println("成员变量名称：" + field.toString());
        }

        System.out.println("类名字：" + class1.getName());
        System.out.println("获取成员变量：" + class1.getFields());
        System.out.println("获取成员方法：" + class1.getMethods());
        System.out.println("获取构造函数：" + class1.getConstructors());

        Person person = class1.newInstance();
        System.out.println(person);

        Constructor<Person> constructor = class1.getConstructor();

        constructor.setAccessible(true);

    }
}
