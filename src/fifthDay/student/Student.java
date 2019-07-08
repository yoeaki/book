package fifthDay.student;

public class Student {

    private String name;

    private Integer age;

    private String sex;

    private String phone;

    private Integer num;

    private Double height;

    public Student() { }

    public Student(String name, Integer age, String sex, String phone, Integer num, Double height) {
        this.name = name;
        this.setAge(age);
        this.sex = sex;
        this.phone = phone;
        this.num = num;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age > 3 && age <30)
            this.age = age;
        else
            this.age = 18;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getnum() {
        return num;
    }

    public void setnum(Integer num) {
        this.num = num;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", num=" + num +
                ", height=" + height +
                '}';
    }
}
