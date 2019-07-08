public class ChangeDemo {

    public static void main(String[] args) {
        int a = 50;
        int b = 80;

        a = b + a;  //a = 130
        b = a - b;  //b = 50
        a = a - b;  //a = 80

        System.out.println(a +"," + b);
    }
}
