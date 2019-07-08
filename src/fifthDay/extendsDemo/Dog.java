package fifthDay.extendsDemo;

public class Dog extends Animal{

    private String color;

    private Integer age;

    private Double weight;

    public Dog(String color, Integer age, Double weight) {
        this.color = color;
        this.age = age;
        this.weight = weight;
    }

    public Dog(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
