package process;

public class ThreadDemo11 {

    public static void main(String[] args) {

        /**
         * 设置线程优先级
         *      1.setPriority（）设置线程优先级
         *      2.线程优先级从1 ~ 10
         *      3.每个线程都有个默认优先级5，比如main函数,数字越大，优先级越高
         *      4.查看线程对象信息Thread.currentThread()
         * */

        System.out.println("当前对象线程信息" + Thread.currentThread());

        ThreadDemo11C td11c = new ThreadDemo11C();
        ThreadDemo11C1 td11c1 = new ThreadDemo11C1();

        td11c.start();
        td11c1.start();
        System.out.println("11111");
        td11c.setPriority(3);


    }
}

class ThreadDemo11C extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("当前子线程A对象线程信息" + Thread.currentThread());
        }
    }
}
class ThreadDemo11C1 extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("当前子线程B对象线程信息" + Thread.currentThread());
        }
    }
}
