package factory;

public class DogFactory extends AnimalFactory{

    @Override
    public Animal createAnimal() {
        Dog dog = new Dog();

        dog.setName("小黑");
        dog.setAge(10);
        dog.setColor("黑色");
        return dog;
    }

    @Override
    public Animal newAnimal() {
        return new Dog();
    }
}
