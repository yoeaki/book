package seventh.mapDemo;

import sixthDay.student.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mapDemo {

    public static void main(String[] args) {

        Map<String, Student> map = new HashMap<String,Student>(16);

        Student stu1 = new Student("admin", 18, "男", "1234567", 01, 174.1);
        Student stu2 = new Student("陈前前", 18, "男", "1234567", 01, 174.1);
        Student stu3 = new Student("yoeaki", 18, "女", "1234567", 01, 174.1);

        map.put("stu1",stu1);
        map.put("stu2",stu2);
        //key一样会把value值替换
        map.put("stu1",stu3);

        Set<String> stringKey = map.keySet();

        for (String key:
             stringKey) {
            System.out.println(map.get(key));
        }

        Iterator<Map.Entry<String,Student>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Student> entry = it.next();
            System.out.println("键：" + entry.getKey() + "，值：" + entry.getValue().getName());
        }
    }
}
