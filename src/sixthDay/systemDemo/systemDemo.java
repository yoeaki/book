package sixthDay.systemDemo;

import java.util.Properties;

public class systemDemo {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        String str = properties.toString();
        String rePlace = str.replace(",","\n");
        System.out.println(rePlace);
        /*System.out.println(System.getProperties());*/
        System.out.println("===================");
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println();
    }
}
