package SecondDay;

public class ForAndWhile {


    public static void main(String[] args) {

        /**
         * 练习for和while
         * */

        for
        (int i = 0; i < 200; i++) {
            if (i%3 == 0 & i%5 == 0){
                System.out.println(i);
            }
        }

        String str = "ILoveyou";

        char[] chars = str.toCharArray();
        System.out.println(str.charAt(2));
        for (char c:chars){
            System.out.println(c);
        }



    }
    public static void add(){}

}