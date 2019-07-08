package throwable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo1 {
    public static void main(String[] args) {

        /**
         *  编译时异常
         *  运行时异常
         *
         * */

        //编译时异常，编译不通过
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        }catch (FileNotFoundException e){
            System.out.println(e + "找不到文件路径");
        }
    }
}
