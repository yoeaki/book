package FirstDay;

public class Demo1 {

    public static void main(String[] args) {

        System.out.println("I love java!");

        //自动拆箱
        Integer num = 1234;
        int aaa = num;

        //自动装箱
        int intNumber = 1231;
        Integer bbb = intNumber;

        String s = "1231";

        System.out.println("拆箱：" + aaa );
        System.out.println("装箱：" + bbb );

        String str = String.valueOf(bbb);
        Integer changeInteger = Integer.valueOf(s);

        System.out.println("Integer转String：" + str +
                            "类型：" + str.getClass());

        System.out.println("String转Integer：" + changeInteger +
                            "类型：" + changeInteger.getClass());

        Integer integer = changeInteger.hashCode();



    }
}
