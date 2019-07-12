package day07.test01.demo2;

import day07.test01.demo.DemoTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static day07.test01.demo2.Size.LARGE;

public class EnumTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        String s = Size.SAMll.getAbbreviation();
        Size.SAMll.setAbbreviation("1231");
        System.out.println(s);

        //改变SAMLL的枚举值
        Size.SAMll.setAbbreviation("1231");
        String s2 = Size.SAMll.getAbbreviation();
        System.out.println("改变后的枚举类值：" + s2);
        System.out.println("返回枚举类的位置：" + Size.EXTAR_LARGE.ordinal());
        System.out.println("比较枚举类的位置关系：" + Size.SAMll.compareTo(LARGE));

        System.out.println("=================");


    }
}
