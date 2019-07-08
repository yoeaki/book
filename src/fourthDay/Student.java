package fourthDay;

/**
 *
 * @author yoeaki
 * @Classname Student
 * @Description TODO
 * @date 2019/6/10 9:37
 */
public class Student extends Father{

    /** 学号 */
    private String num;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private int age;

    public void eat(){
        System.out.println("孩子在吃饭");
    }
    public Student(){
        System.out.println("孩子的无参构造函数！");
    }

    public Student(String money, String num, String name, int age) {

        super(money);
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public Student(String num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }
    /*@Override
    public void run() {
        System.out.println("孩子在跑步！");
    }*/

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
        this.age = age;
    }
}
