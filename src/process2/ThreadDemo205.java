package process2;

public class ThreadDemo205 {

    public static void main(String[] args) {

        /**
         * 线程组的概述和使用（了解）
         *      一、线程组概述：
         *          1.java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，
         *          2.java默认情况下，所有的线程都是属于线程组
         *              public final ThreadGroup getThreadGroup() 通过线程对象获取他的对象
         *              public final String getName() 通过线程组对象获取他组的名字
         *          3.他们也可以给线程设置分组
         *              ThreadGroup（String name）创建线程组对象并且赋值名字
         *     二、创建线程对象
         *          Thread(ThreadGroup?group,Runnable?target,String?name) 提供一个线程组，线程，县城名字
         *
         * */

        //主线程
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread);

        ThreadGroup t1 = mainThread.getThreadGroup();
        System.out.println("线程组名称：" + t1.getName());
    }
}
