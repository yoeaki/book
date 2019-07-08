package fourthDay.homeWork;

public class Student {

    private String name;
    private int age = 19;
    private char sex;
    private double math;
    private double chinese ;
    private double english;
    public static String provice;

    public Student(){}

    public Student(String name, char sex, double math, double chinese, double english) {
        this.setName(name);
        this.setSex(sex);
        this.setMath(math);
        this.setChinese(chinese);
        this.setEnglish(english);
    }

    public Student(String name, int age, char sex, double math, double chinese, double english) {

        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
        this.setMath(math);
        this.setChinese(chinese);
        this.setEnglish(english);
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", math=" + math +
                ", chinese=" + chinese +
                ", english=" + english +
                ",总分：" + getAll() +
                ",平均分：" + getAvg()
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 19 && age < 40)
            this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getAll(){
        return (math + chinese +english);
    }

    public double getAvg(){
        return (math + chinese +english)/3;
    }
}
