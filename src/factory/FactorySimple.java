package factory;

import java.util.concurrent.Executors;

public class FactorySimple {

    /**
     * 工厂设计模式
     *      1.工厂方法模式
     *      2.简单工厂模式  Executors.newCachedThreadPool();
     *          静态工厂，它定义一个具体得工厂类负责创建一些类得实例
     * */

    public static void main(String[] args) {

        CarFactory.createBicfcycle().run();
    }
}
