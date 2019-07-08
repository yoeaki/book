package fourthDay;

public class Father {

    public static String money = "144";
    public static String color = "黄色";
    String sex = "男";

    public static Father father;

    public void run(){
        System.out.println("父亲在跑步！");
    }

    public Father(String money) {
        System.out.println("我带一个参数初始化！");
        this.money = money;
    }

    public Father(){
        System.out.println("父亲的无参构造函数！");
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
