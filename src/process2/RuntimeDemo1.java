package process2;

import java.io.IOException;

public class RuntimeDemo1 {

    public static void main(String[] args) throws IOException {

        /**
         * Runtime类也是单例模式
         *      定时300毫秒关机
         *          rt1.exec("shutdown -s -t 300")
         *      取消定时关机
         *          rt1.exec("shutdown -a")
         * */

        Runtime rt1 = Runtime.getRuntime();
        System.out.println(rt1);

         rt1.exec("shutdown -s -t 300");
         rt1.exec("shutdown -a");
    }
}
