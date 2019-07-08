package seventh.exception;

public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            int i= 10 / 0;
        }catch (Exception e){
            System.out.println(e);
            System.out.println(System.err);
        }

        System.out.println(System.console());
    }

}
