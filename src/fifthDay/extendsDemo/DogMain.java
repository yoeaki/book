package fifthDay.extendsDemo;

public class DogMain {

    public static void main(String[] args) {

        Dog dog1 = new Dog("黄色",18,17.5);
        Dog dog2 = new Dog("黄色",18,17.5);

        System.out.println(dog1.getAge().equals(dog2.getAge()));
        System.out.println(dog1.getAge() == dog2.getAge());

        System.out.println("==========================");

        System.out.println(dog1 == dog2);
        System.out.println(dog1.equals(dog2));

    }
}
