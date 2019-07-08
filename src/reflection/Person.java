package reflection;

public class Person {

    public String name;
    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public void eat(){
        System.out.println("I am eating!");
    }
    public void run(){
        System.out.println("I am running!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
