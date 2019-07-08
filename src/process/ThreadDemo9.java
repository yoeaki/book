package process;

public class ThreadDemo9 {

    public static void main(String[] args) {

        /**
         * 守护线程
         *      1.setDaemon（）设置一个守护线程，该线程不会单独执行
         *      2.当其他非守护线程都执行结束后，自动退出
         *      3.setDaemon(true)必须在调用线程的start（）方法之前设置，否则会抛出IllegalThreadStateException异常。
         * */

        //线程女举例
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println("线程-女：" + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        //线程男创建
        Thread t2 = new Thread(){
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println("线程-男：" + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //开启
        t2.setDaemon(true);
        t1.start();
        t2.start();


    }
}
