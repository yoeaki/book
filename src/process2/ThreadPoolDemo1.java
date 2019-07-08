package process2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {

    public static void main(String[] args) {

        /**
         * 线程池:提高性能
         *      1.程序启动线程的成本很高，它涉及到了交互系统的操作，而使用线程池很好的提高性能
         *      2.程序中要创建线程需要启动大量生命周期很短的线程时，应考虑线程池
         *      3.使用线程池，每个线程代码结束后，并不会死亡，而是回到线程池成为空闲状态，等待下一个对象使用
         *      4.java内置支持线程池。
         * java内置线程池
         *      1.jdk5新增加的Executors工厂类来生成线程池
         *          public static ExecutorService newFixedThreadPool(int nThreads)
         *          public static ExecutorService newSingleThreadExecutor()
         *      2.这些方法可以返回ExecutorService对象，该对象表示一个线程池
         *          可以执行Runnable对象或者callable对象代表进程
         *              Future<?> submit(Runnable task)
         *              <T> Future<T> submit(Callable<T> task)
         *              区别：
         *              Runnable（任务）无返回值，callable有返回值
         *      3.使用步骤：
         *          1.创建线程池对象
         *          2.创建Runnable实例
         *          3.提交Runnable实例
         *          4.关闭线程es.shutdown();
         *
         * */

        //创建10个线程，完成10洗车任务
        /*for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println("洗车任务" + Thread.currentThread());
                }
            }.start();
        }*/

        //5个线程，完成10个洗车任务
        //1.创建线程池
        ExecutorService es = Executors.newFixedThreadPool(5);

        //2.添加任务方式一
        /*for (int i = 0; i < 10; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("洗车任务" + Thread.currentThread());
                }
            });
        }*/

        /*
        2.添加任务方式二、
        */
        for (int i = 0; i < 10; i++) {
            es.submit(new MyTask());
        }

        //线程池关闭，一般不会关闭线程池
        es.shutdown();

    }
}

class MyTask implements Callable{

    /**
     * call()与run（）方法类似
     * */
    @Override
    public Object call() throws Exception {
        System.out.println("洗车任务" + Thread.currentThread());

        return null;
    }


}
