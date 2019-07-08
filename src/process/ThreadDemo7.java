package process;

public class ThreadDemo7 {

    public static void main(String[] args) {

        /**
         * 线程休眠（掌握）
         *      Thread.sleep(毫秒ms)
         *      1s = 1000ms
         * 用途：
         *      1.验证码   2.倒计时器
         *
         * 调用区别
         *      1.子线程不会影响主线程运行
         *      2.先执行主线程的内容，同时进行
         *      3.尽量不要在主线程休眠
         *      4.主线程总比子线程优先
         *      5.两个子线程也不会相互影响
         * */

        /**
         * 开启一个子匿名线程
         *      ThreadDemoC7
         * */

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("当前第一个子线程对象：" + Thread.currentThread());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("当前第二个子线程对象：" + Thread.currentThread());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        //主线程休眠
        /*for (int i = 0; i < 10; i++) {
            System.out.println("当前主线程对象：" + Thread.currentThread());
            try{
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }*/

        System.out.println("我是在主线程上的");
    }
}
