package FirstDay;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class StudentMain {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //HashMap传递
        Map map = new HashMap<String,Object>(16);
        map.put("name","bqx");
        map.put("age",18);
        map.put("height",178);
        //创建学生对象
        Student st = new Student();
        Student st2 = new Student("袁熙龙",17,175.22);
        /*Student st3 = new Student(map);*/
        System.out.println(map.get("name"));

        System.out.println(map);

        //输出第一个学生信息
        System.out.println(st.getName());
        System.out.println(st.getAge());
        System.out.println(st.getHeight());

        //输出第二个学生信息
        System.out.println(st2.getName() + "   我吃\n饭了");
        System.out.println(st2.getName() + "l我发撒发的撒范德萨\t饭");
        System.out.println(st2.getAge());
        System.out.println(st2.getHeight());

        //字节占用情况练习
        String s = "我";
        String s2 = "k我";
        System.out.println("UTF-8:" + s.getBytes("UTF-8").length);
        System.out.println("UTF-8:" + s.getBytes("GBK").length);
        System.out.println("UTF-8:" + s2.getBytes("UTF-8").length);
        System.out.println("UTF-8:" + s2.getBytes("GBK").length);
    }
}
