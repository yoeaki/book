package date;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public void transForm(){

        long now1 = System.currentTimeMillis() / (1000 * 60 * 60);
        long now2 = new Date().getTime() / (1000 * 60 * 60);
        String time1 = "2019-04-01 15:00:00";
        long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(time1, new ParsePosition(0)).getTime() / (1000 * 60 * 60);
        System.out.println("字符串转换为时间戳：" + time);
        System.out.println("同时时间戳" + (now1 - now2));
        System.out.println("时间戳相减" + (time - now1));
        if ((now1 - time) > 2){
            System.out.println("true");
        }else {
            System.out.println("flase");
        }
        System.out.println(now1);
        System.out.println(now2);


        System.out.println(new Date().getTime());
    }
}
