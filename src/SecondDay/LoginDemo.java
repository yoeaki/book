package SecondDay;

import java.util.Scanner;

public class LoginDemo {

    public LoginDemo(){}
    public LoginDemo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String userName;
    private String passWord;

    public static void main(String[] args) {

        /**
         * 密码匹配登录案例
         * */
        //创建本对象实例
        LoginDemo loginDemo = new LoginDemo();

        LoginDemo loginDemo1 = loginDemo.printInfo();

        if (loginDemo.login(loginDemo1.getUserName(),loginDemo1.getPassWord())){
            System.out.println("登录成功！");
        }else {
            System.out.println("用户名或者密码错误");
        }


    }

    public Boolean login(String userName, String passWord){

        //确认用户名密码正确性
        Boolean ack = false;

        //登录信息
        String name = "amdin";
        String pass = "admin";
        System.out.println(userName + passWord);
        System.out.println(this.userName.equals(name) && this.passWord.equals(pass));

        if (name.equals(userName) && pass.equals(passWord)){
            ack = true;
        }
        return ack;
    }

    public LoginDemo printInfo(){

        //创建键盘Scanner实例
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名");
        this.userName = sc.nextLine();

        System.out.println("请输入密码：");
        this.passWord = sc.nextLine();
        return new LoginDemo(userName,passWord);
    }
}
