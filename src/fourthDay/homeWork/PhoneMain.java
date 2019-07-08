package fourthDay.homeWork;

public class PhoneMain {

    public static void main(String[] args) {

        Phone p = new Phone("oppo","174135415",5999.00,"5.9英寸","红色");

        String str = "saf";
        String brand = p.getBrand();
        System.out.println(p.toString());

    }
}
