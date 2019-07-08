package fourthDay.homeWork.extendsDemo;

import java.util.HashMap;

public class Man extends Person {

    private String sex;

    public Man(String name, String num) {
        super(name, num);
    }

    public void get() {
        System.out.println(this.name);
        System.out.println(this.getNum());
    }
}
