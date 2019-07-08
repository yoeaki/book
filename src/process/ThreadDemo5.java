package process;

public class ThreadDemo5 {
    public static void main(String[] args) {

        /**
         * 获取线程名字和设置名字
         *      1.通过Thread.currentThread()方法获取线程对象
         *      2.通过Thread.currentThread()getName（）方法获取线程名称
         *      3.通过Thread.currentThread()setName（string）设置线程名称
         *
         * */

        //1.获取主线程对象
        System.out.println("通过Thread.currentThread()获取线程对象：" + Thread.currentThread());
        System.out.println("通过Thread.currentThread().getName()获取线程名称:" + Thread.currentThread().getName());

        //设置线程名称
        Thread.currentThread().setName("主线程");
        System.out.println("通过Thread.currentThread().setName()设置线程名称:" + Thread.currentThread());

        //创建线程
        ThreadDemoC1 tdc = new ThreadDemoC1("newThreadName");

        //启动线程
        tdc.start();

    }
}

class ThreadDemoC1 extends Thread{

    public ThreadDemoC1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("创建一个线程" + Thread.currentThread());
    }
}
