package FirstDay;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private String name = "Henry";
    private int age = 14;
    private double height = 175.88;

    /**
     *
     * @Description TODO
     * @date 2019/6/3 16:31
     * @params [name, age, height]
     * @return
     * @Exception
     */
    public Student(String name,int age,double height){
      this.name = name;
      this.age = age;
      this.height = height;
    }

    public Student(Map map){
    }
    public Student(){}

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
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
