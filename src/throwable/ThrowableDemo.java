package throwable;

public class ThrowableDemo {
    public static void main(String[] args) {
        /**
         *
         * Throwable 时编译时异常（Exception）和运行时异常（runtime）的父类
         * Throwable常用的几个方法：
         * getMessage 返回异常信息（by zero）
         * getClass 返回异常类型，该异常属于哪一个具体类
         * toString 获取异常信息，返回字符串
         * PrintStackTrace 打印异常信息类名和异常信息，异常程序的位置
         *
         * */

        int max = 10;
        int min = 0;
        try{
            int endNum = max /min;
            System.out.println(endNum);
        }catch (ArithmeticException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            e.printStackTrace();    //打印异常信息
            return;
        }finally {
            System.out.println("最后执行");
        }
        System.out.println("打印异常后运行我");
    }
}
