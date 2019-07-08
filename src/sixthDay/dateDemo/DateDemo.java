package sixthDay.dateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) throws ParseException {
        
        /**
         * 时间转换
         *     1.三种获取时间的方式
         *     2.Date --->  String
         *          a)Date date = new Date();
         *          a)格式化：SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss:sss");
         *          b)sdf.format(date)   //转为String
     *         3.String  ---> Date
         *         a)设置一个时间字符串 String strDate = "2019-06-12 18:20:30:154";  //格式要和SimpleDateFormat定义的一致
         *         b)sdf.parse(strDate);  //转为Date
         * */

        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        System.out.println(date);

        //格式化时间（Date）yyyy-mm-dd hh:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss:sss");
        System.out.println(sdf);

        //格式化函数(format)转为字符串时间
        String dateString = sdf.format(date);
        System.out.println(dateString);
        
        //字符串转换为时间
        String dateStr = "2019-06-13 18:20:30:154";

        Date date2 = sdf.parse(dateStr);
        System.out.println(date2);

        //时间转为时间戳
        long time1 = date2.getTime();
        System.out.println("时间戳：" + time1);
        String getValue = String.valueOf(time1);
        System.out.println("时间戳字符串：" + getValue);

        //字符串时间戳转为格式化日期
        long lt = new Long(getValue);

        Date dateTime = new Date(lt);

        String dateString1 = sdf.format(dateTime);

        System.out.println("字符串时间戳转为格式化时间：" + dateString1);

        long ct1 = date2.getTime();
        long ct2 = System.currentTimeMillis();
        Date nowTime = new Date();
        System.out.println("现在时间：" + nowTime);

        System.out.println("两时间相差得天数为：" + (ct1 - ct2));

    }
}
