package sixthDay.stringDemo;

public class Demo1 {
    public static void main(String[] args) {

        String str1 = new String("wo aini ");

        String hello = "hello";
        System.out.println("长度" + hello.length());

        //返回字符的hash值，一般再转码的时候用到。
        byte[] bytes = hello.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        //找到索引值，找到返回索引，找不到返回-1
        //从前往后找
        int e = hello.indexOf('e');
        System.out.println("索引值：" + e);
        //从前往后找
        int e2 = hello.lastIndexOf('e');
        System.out.println("索引值：" + e2);

        //从后往前找

        //判断是否以某个字符开头/结尾
        boolean h = hello.startsWith("h");
        boolean e3 = hello.startsWith("e");
        boolean o = hello.endsWith("o");
        boolean d = hello.endsWith("d");
        System.out.println("hello以h开头：" + h);
        System.out.println("hello以e开头：" + e3);
        System.out.println("hello以o结束：" + o);
        System.out.println("hello以d结束：" + d);

        System.out.println("从给定的第i个开始截取" + hello.substring(2));
        System.out.println("从给定的第i个开始到j个结束，不算后面那个截取" + hello.substring(1,2));

        String st3 = "Henry      ";
        System.out.println("未去掉空白符号后的字符长度" + st3.length());
        String trim = st3.trim();
        System.out.println("去掉空白符号后的字符长度" + trim.length());
    }

}
