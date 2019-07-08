package factory;

public class FactoryMethod {

    public static void main(String[] args) {

        /**
         * 工厂设计模式
         *      1.工厂方法模式
         *          工厂方法模式中抽像工厂类负责创建对象接口，
         *          具体对象得创建由继承抽象工厂得具体类实现
         *          优点：
         *              1.客户端不需要负责对象创建，从而明确工厂指责
         *      2.简单工厂模式  Executors.newCachedThreadPool();
         *
         * */

        /*Dog dog = new Dog();
        Pig pig = new Pig();

        dog.eat();
        pig.eat();

        DogFactory dogFactory = new DogFactory();
        Dog dog1 = (Dog) dogFactory.createAnimal();
        dog1.eat();*/

        PigFactory pigFactory = new PigFactory();

        DogFactory dogFactory = new DogFactory();
        Dog dog = (Dog) dogFactory.createAnimal();
        Dog dog1 = (Dog) dogFactory.createAnimal();

        System.out.println(dog.getName());
        System.out.println(dog1.getName());

    }
}
