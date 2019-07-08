package factory;

public class Dog extends Animal{

    private String  name;
    private int     age;
    private String  color;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public void eat() {
        System.out.println("狗吃了");
    }
}
