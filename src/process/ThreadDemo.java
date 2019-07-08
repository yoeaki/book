package process;

public class ThreadDemo {
    public static void main(String[] args) {
        /**
         *  1.一个应用可以用多个进程，一个进程可以拥有至少一条或者多条线程
         *  2.多线程并发可以提高效率，即可以同时完成多个工作
         * */

        /**
         *  1.并发和并行
         *      并发：在某一个时间段内，任务在某个时间片内交替执行，时间短，感觉是同时进行（在一个时间线内轮流进行）
         *           例如：吃饭的时候：你夹菜，然后吃
         *      并行：在同一个时间段内，任务互不干扰的进行各个任务的事情，同时进行（在一个时间内，两个互不干扰的同时进行）
         *           例如：你在吃饭，你爸爸在看电视，两个互不干扰
        * */

        /**
         * java运行原理：
         *      启动JVM（启动一个应用程序） —》 生成“主线程” —》 调用某个类的main方法
         * java启动是多线程吗？
         *      java虚拟机至少启动了垃圾回收线程和主线程，所以是多线程，多线程都是抢占资源的。
         *      垃圾回收和主线程打印顺序是不一样的，多线程都是抢占资源的。（？？？）
         *      System.gc():  //垃圾回收调用
         * 一个应用程序（相当于一个进程）：一条主线程 (main方法在主线程中)+ 若干个子线程
         *
         * Thread[main,5,main]  ： main是线程名称， 5是线程优先级，main：父线程所属main
         *
         * */

        //java JVM多线程模仿
        System.out.println("AAAAA");
        System.out.println("BBBBB");
        System.out.println("CCCCC");
        System.out.println("DDDDD");



        for(int i = 1; i < 3;i++){
            new Student();
            System.gc();
        }

        //打印当前线程对象名称
        System.out.println(Thread.currentThread());

    }
}

//学生类
class Student{

    /**
     * finalize 当对象被释放的时候会调用
     * */
    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread());
        System.out.println("进程被回收了。。。");
        super.finalize();
    }
}
