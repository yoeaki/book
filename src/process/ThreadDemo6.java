package process;

public class ThreadDemo6 {

    public static void main(String[] args) {

        /**
         *  掌握
         *      1.获取线程对象    2.设置线程名称    3.获取线程类型
         *      Thread.currentThread   setName()      getClass()
         * */

        ThreadDemo6C1 td6c = new ThreadDemo6C1("ThreadDemo6C1");
        td6c.start();

    }
}

class ThreadDemo6C1 extends Thread{

    public ThreadDemo6C1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
        System.out.println("线程类型:" + Thread.currentThread().getClass());
    }
}
