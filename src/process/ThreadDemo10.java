package process;

public class ThreadDemo10 {

    public static void main(String[] args) {

        /**
         *  加入线程
         *      join(),当前线程暂停，等待指定的线程执行结束后，当前线程再继续
         *      join(int),可以等待指定的毫秒结束后继续
         *      t1
         *      t1.join(毫秒ms)，加入线程毫米，所有的资源都给t1使用
         *
         * */

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    System.out.println("线程A" + i);

                    try{
                        Thread.sleep(10);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程B" + i);
                    try{
                        Thread.sleep(10);
                        t1.join(50);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
        };

        t1.start();
        t2.start();
    }
}
