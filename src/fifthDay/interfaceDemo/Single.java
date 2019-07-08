package fifthDay.interfaceDemo;

public class Single extends Dog implements A,B,C{

    @Override
    public void run() {
        System.out.println("A跑起来了");

    }

    @Override
    public void eat() {
        System.out.println("B吃起来了");
    }

    @Override
    public void sleep() {
        System.out.println("C睡起来了");
    }

    @Override
    public void move() {
        System.out.println("小狗移动了");
    }
}
