package Io;

public class Test {

    /*
    * 除法运算
    */

    /*
    * JAVAEE 服务端开发,一般底层开发，从底层往上抛
    * 安卓，客户端开发，try{}catch(Exception e){}
    * 捕获异常的时候，小的异常放前面，大的异常方后面（多态原理）
    * */

    /*父类引用指向子类对象
    * JVM用一个默认异常处理机制,会将错误打印在控制台
    * */
    public int division(int a, int b){      //a = 10,b = 0
        return a / b;                       //10 / 0 被除数为0，违背了算术运算法则
                                            //JVM虚拟机自己解决，没有解决方案会将一场抛出，交给函数处理
                                            //new了一个ArithmeticException（“/by zero”）
    }

    /*
    * Try:用来检测异常
    * catch：用来捕获异常
    * finally：释放资源（可以对IO流，数据进行资源释放）
    *
    * try catch异常捕获
    *       备胎定理：世界上最真情的爱就是，你是try，我是catch，不管你怎么样了，我都等你，静静为你处理
    * try catch处理多个异常
    *
    *
    **/

    public void split(String str){
        String regex = "\\s";
        String newStr = str.toString();


            System.out.print(newStr.replace(" ","%20"));

    }
}
