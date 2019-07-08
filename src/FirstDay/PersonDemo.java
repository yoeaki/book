package FirstDay;

public class PersonDemo {

    private String name = "Henry";
    private String sex = "男";
    private String num = "201609601285";
    private int age = 14;
    private double weight = 145;
    private String email = "1743182950@qq.com";

    public PersonDemo(){}

    public PersonDemo(String name, String sex, String num, int age, double weight, String email) {
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.age = age;
        this.weight = weight;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}