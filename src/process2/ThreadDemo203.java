package process2;

import java.util.*;

public class ThreadDemo203 {

    /**
     * 线程安全问题面试题
     *      Vector和ArrayList有什么区别
     *          1.Vector线程安全，ArrayList是线程不安全。
     *              Vector声明了synchronized同步，而ArrayList没有
     *          2.StringBuffer和StringBuild
     *              StringBuffer是线程安全的，StringBuild是线程不安全的
     * */

    public static void main(String[] args) {

        /**
        * 测试
        * */

        Vector v = new Vector();
        ArrayList arr = new ArrayList();

        StringBuffer sbf;
        StringBuilder sbd;

        Map map = new HashMap();
        Hashtable table = new Hashtable();

        Collections collections;
    }
}
