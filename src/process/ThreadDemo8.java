package process;

public class ThreadDemo8 {

    public static void main(String[] args) {

        /**
         * 内容：倒计时60秒
         *      子线程进行倒计时
         *
         * 面试题：
         *      局部类访问可以访问局部变量，但这个变量声明必须为final
         * */

        //创建一个60秒时间
        int seconds = 60;

        //开始倒计时
        new Thread(){
            @Override
            public void run() {
                for (int i = seconds; i >= 0; i--) {
                    System.out.println("剩余：" + i + "秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
