package sixthDay.randomDemo;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            System.out.println("整型" + random.nextInt());
        }
        System.out.println("========================");

        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(20));
        }
        System.out.println("========================");

        for (int i = 0; i < 5; i++) {
            System.out.println((int)(random.nextDouble()*10));
        }

        System.out.println("========================");

        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextBoolean());
        }

        System.out.println("========================");
    }
}
