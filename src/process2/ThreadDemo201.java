package process2;



public class ThreadDemo201 {

    public static void main(String[] args) {

        /**
         * 同步代码块和同步方法
         *      一、什么情况下需要同步？
         *          1.在多线程并发，有多段代码快同时执行时，我们希望某一段代码执行过程中CPU不要切换到其他线程工作中
         *          2.如果两段代码是同步的，同一段时间只能执行一段，没执行结束之前不会执行另一段
         *      二、同步代码块
         *          1.synchronized关键字加上一个锁对象来定义一段代码，叫做同步代码块
         *          2.多个同步代码块如果使用相同的对象，那么他们就是同步的
         *      三、同步方法
         *          1.使用synchronized关键字修饰一个方法，该方法中所修饰的代码都是同步的
         *          2.非静态同步函数锁是：this
         *          3.静态同步函数的锁是：字节码对象（xx.class）
         *          4.在返回值前面加synchronized为同步
         *              非静态同步函数锁是：this
         *              静态方法为编译后的自己码对象，Ticket.class(字节码对象)
         *      四、加锁，可以解决进程在同一时刻运行的的问题
         *          1.存在的问题：
         *              a）synchronized （this）{
         *                  //锁住了所包含的代码块，所以进程A进来后，就只能等进程A运行结束后才能让进程B执行。
         *              }
         *          2.尽量锁住的范围小一点，让线程等待的时间小些，资源节省
         *
         * */

        //同步代码块和同步方法

        /**
         * 火车站卖票
         *      湖南到广州火车票：13：00，100张
         *      火车站有4个窗口同时在卖，保证一张票只能被卖一次
         *
         *      4个线程表示4个窗口，保证一张票只能卖一次
         * */

        //创建多个窗口线程
        Ticket1 ticket = new Ticket1();
        Thread t2 = new Thread(ticket);
        Thread t1 = new Thread(ticket);

        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");
        t4.setName("窗口D");
        t2.start();
        t1.start();

        t3.start();
        t4.start();
    }
}


class Ticket1 implements Runnable {

    int ticket = 100;

    @Override
    public void run() {

        while (true){

            //this是一个锁对象，可以是任何东西，当这个对象为同一个东西的时候，就会上锁成功
            //this指的是该类创建的对象
            synchronized (this){
                if (ticket <= 0) {
                    System.out.println("票卖完了");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + "你当前的票数是：" + ticket);
                    ticket--;
                }
            }

        }


    }
}