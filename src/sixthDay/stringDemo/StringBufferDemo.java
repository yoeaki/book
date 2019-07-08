package sixthDay.stringDemo;

public class StringBufferDemo {
    public static void main(String[] args) {

        StringBuilder stringBuilder1 = new StringBuilder("Hello");

        StringBuilder world = stringBuilder1.append("World");

        String str = "Hello";

        System.out.println(world);
        System.out.println(world.toString());

        //多线程用buffer
        //单线程用builder
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            /*buffer.append(i);*/
            /*builder.append(i);*/
            str += i;
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
