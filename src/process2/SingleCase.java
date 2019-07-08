package process2;

public class SingleCase {

    public static void main(String[] args) {

        /**
         * 单例设计模式
         *      1.保证类内存中只有一个对象
         *          a.对象是new出来的，
         *          b.所以在程序中保证只new一次
         *      2.单例模式实现的步骤
         *          a.声明一个类，类中有一个属性类型的类型相同
         *          b.把构造方法声明为私有
         *          c.在类中提供一个公共的静态方法来返回该对象的实例
         *      3.实现单例方法
         *          1.饿汉式
         *              空间换时间，
         *              在多线程不会创建多个对象
         *          2.懒汉式
         *              时间换空间
         *              在多线程中有可能会创建多个对象
         *          3.简单模式
         *      4.考虑线程安全问题：选择饿汉式
         * */

        //实现单例写法一:饿汉式
        System.out.println("------饿汉式");
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(Singleton.getInstance());

        //实现方式二：懒汉式
        System.out.println("-----懒汉式");
        Singleton2 s2 =Singleton2.getInstance();
        System.out.println(s2);
        System.out.println(Singleton2.getInstance());

        //实现单例写法三：简单式
        /*
          存在问题：
                若存在子类可以改变实例对象：Singleton3 s3 = new children();
          解决问题：
                在类中的变量加final
        * */
        System.out.println("-----简单式");
        Singleton3 s3 =Singleton3.instance;
        System.out.println(s3);
        System.out.println(Singleton3.instance);

    }
}

/**
 * 饿汉式
 * */
class Singleton {

    /**
     * 声明私有属性
     * 字节码一加载就会new一个对象，字节码只加载一次
     * 方法区（放字节码），一旦字节码加载，堆中就创建一个对象
     * */
    private static Singleton instance = new Singleton();

    private Singleton(){}

    /**
     * 返回对象实例
     * */
    public static final Singleton getInstance(){
        return instance;
    }
}

/**
 * 懒汉式
 * */
class Singleton2 {

    /**
     * 定义一个静态类成员变量
     * */
    private static Singleton2 instance;

    private Singleton2(){}

    /**
     * 多线程访问时有可能同时访问，该方法，同时会new
     * 可以进行加锁，但是太耗内存
     * */
    public static Singleton2 getInstance(){
        if (instance == null)
            instance = new Singleton2();
        return instance;
    }
}

/**
 * 实现方式三
 * */
class Singleton3{

    /**
     * 访问控制符用public，static在类外部可以直接使用
     *      public static Singleton3 instance = new Singleton3();
     * */
    public static Singleton3 instance = new Singleton3();

    private Singleton3(){}
}
