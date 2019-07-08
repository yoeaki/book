package process2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyWait  {

    public static void main(String[] args) {

        /**
         * 线程之间的通信
         *      什么时候需要通信？
         *          1.多个线程并发执行的时候，默认情况是随机切换
         *              如果我们希望他们有规律执行，就可以使用线程通信，每次执行一次打印
         *      怎么通信？
         *          1.希望线程等待就用wait()
         *          2.希望唤醒等待线程就用notify（）；
         *          3.这两个方法必须在同步代码中执行，并且使用同步锁对象使用。
         *
         *      注意：
         *          1.wait（）、notify（）是Object对象里面的，因为synchronized（this）可以接收任何对象
         *          2.wait（）、和notify不传参数则，一直等待或者开启线程。
         *          3.sleep（）需要传参数，即是睡眠时间
         *
         * */

        Mytask mytask1 = new Mytask();
        Mytask mytask2 = new Mytask();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        mytask2.task2();
                        System.out.println("Hhh");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

       /* new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        mytask1.task1();
                        System.out.println("hhh");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/



    }
}


/**
 * 1.添加互斥锁对象
 * 2.创建Condition
 * 3.加锁 r1.lock（）代替synchronized
 *      c1.await(等待时间)等待
 *      c1.notify（）开启线程
 * 4.解锁 r1.unlock（）
 * 5.唤醒指定的线程 c2.signal();
 * */
class Mytask{

    //标识
    public int flag = 2;

    /**
     * 创建互斥锁对象
     * */
    ReentrantLock r1 = new ReentrantLock();

    /**
     * 多少个线程就创建多少个Condition，
    * */
    Condition c1 = r1.newCondition();
    Condition c2 = r1.newCondition();

    public synchronized void task1() throws InterruptedException {

        if (flag != 1){
            this.wait();
        }
        System.out.println("1.信用卡还款！");
        this.flag = 2;

        //唤醒其它线程
        this.notify();
    }

    public synchronized void task2() throws InterruptedException {
        if (flag != 2){
            this.wait();
        }

        System.out.println("信息还款");
        this.flag = 1;
        this.notify();
    }
}


