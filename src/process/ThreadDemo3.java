package process;

public class ThreadDemo3 {
    public static void main(String[] args) {

        /**
         *  线程实现方式2-定义类实现Runnable接口
         *      1.定义类实现runnable接口
         *      2.实现run方法
         *      3.把新线程要做的事情写在run方法中
         *      4.创建自定义runnable子类对象创建Thread对象，传入Runnable
         *      5.调用start（）开启新线程，内部会自动调用Runnable的run（）方法
         *
         *  Runnable实现的步骤
         *      1.创建对象  2.构造参数的调用  3.传一个对象到Runnable的target变量中  4.判断target是否为空  5.不为空则调用
         *
         *  Runnable实现多线程的优缺点：
         *      优点：1.即使有继承有父类耶没关系，因为有了父类也可以实现接口，代码灵活
         *      缺点：2.不能直接使用Thread方法，需要先获得线程对象后，进行传如Thread构造函数中才能使用，代码复杂
         *
         *  用户创建的线程
         *      1.程序员只能创建子线程，不能创建主线程
         * */

        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 6; i++) {
            new Thread(myRunnable).start();
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("银行自动结算信息" + Thread.currentThread().getName());
    }
}
