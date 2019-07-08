package process;

public class ThreadDemo4 {
    public static void main(String[] args) {

        /**
         * 匿名内部类的实现线程的两种方式
         *      1.继承Thread
         *      2.实现Runnable
         *
         * */

        /**
         * 内部类
         * */
        new Thread(){
            @Override
            public void run() {
                System.out.println("内部类创建成功！" + Thread.currentThread());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现Runnable");
            }
        }).start();
    }
}
