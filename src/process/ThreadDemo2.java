package process;

public class ThreadDemo2 {
    public static void main(String[] args) {

        /**
         *  线程实现方式 - 继承Thread实现多线程
         *      1.继承线程Thread
         *      2.重写run方法
         *      3.把新线程要做的事情卸载run方法中
         *      4.创建线程对象
         *      5.开启新线程，内部自动执行run方法
         *
         *  Thread继承实现多线程的优缺点
         *      优点：1.少写代码，代码简单（可以直接使用Thread类中的方法）
         *      缺点：1.如果有继承了父类后，不能再使用继承Thread方式实现多线程
         *
         *  用户创建的线程
         *      1.程序员只能创建子线程，不能创建主线程
         * */

        MyThread t1 = new MyThread();

        /*
        不能通过下面的方式调用来执行任务
        因为这种方法是主线程任务
        银行卡还款短信任务Thread[main,5,main]
        //t1.run();
        */



        /*
         * 正确方式通过调用start（）方法，内部会开启新的线程，进行调用run方法,这样就不会是调用主线程
         * 银行卡还款短信任务Thread[Thread-0,5,main]
         * */

        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        /*
            多线程是抢占资源的，先后顺序看哪个能力强，每一次都不是确定的
        * */
        for (int i = 0; i < 5; i++){
            new MyThread().start();
        }
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        //super.run();  不进行调用

        System.out.println("银行卡还款短信任务" + Thread.currentThread());
    }
}
