package process2;

public class ThreadDemo202 {

    private static String s1 = "筷子左";
    private static String s2 = "筷子右";

    public static void main(String[] args) {

        /**
         * 死锁（了解）
         *      1.多线程同步的时候，如果代码嵌套，使用相同锁，就可能发生死锁
         * 例子：
         *      1.设置两个参数，筷子左和筷子右
         *      2.创建两个新线程
         *          线程一：先锁住S1，再锁住S2
         *          线程二：先锁住S2，再锁住S1
         *      3.锁住的变量都不能被其他访问
         *          当线程一执行用到S1的时候锁住了S1.线程二先锁住了S2
         *          这样线程一想访问S2访问不到，线程二想访问S1访问不到
         *          产生了死锁
        * */

        new Thread(){

            @Override
            public void run() {

                while (true){
                    synchronized (s1){
                        System.out.println("线程A 拿到" + s1 + "等待" + s2);
                    }
                    synchronized (s2){
                        System.out.println("线程A 拿到" + s2 + "开动吃饱");

                    }
                }
            }
        }.start();

        new Thread(){

            @Override
            public void run() {

                while (true){
                    synchronized (s2){
                        System.out.println("线程B 拿到" + s1 + "等待" + s2);
                        synchronized (s2){
                            System.out.println("线程B 拿到" + s2 + "开动吃饱");

                        }
                    }
                }

            }
        }.start();
    }
}
