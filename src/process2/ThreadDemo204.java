package process2;

public class ThreadDemo204 {

    public static void main(String[] args) {

        /**
         * 三个进程的通信
         * */

        Thread1 thread1 = new Thread1();
        Thread th1 = new Thread(thread1);
        th1.start();
    }
}

/**
 * 进程一
* */
class Thread1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
