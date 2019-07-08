package factory;

public class CarFactory {

    /**
     * 定义静态方法创建实例
     * */

    public static BicycleCar createBicfcycle(){
        return new BicycleCar();
    }

    public static TrainCar createTran(){
        return new TrainCar();
    }
}
