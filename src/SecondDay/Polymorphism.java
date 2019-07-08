package SecondDay;

public class Polymorphism {

    public static void main(String[] args) {

        /**
         * 重载
         * */
        Polymorphism p = new Polymorphism();
        p.add(1,5);
        p.add(2,3,5);
        p.add(23,5,6,7);


    }

    public void add(int a, int b){

        System.out.println("获得数值：" + (a + b));
    }
    public void add(int a, int b,int c){

        System.out.println("获得数值：" + (a + b + c));
    }
    public void add(int a, int b, int c,int d){

        System.out.println("获得数值：" + (a + b +c +d));
    }
}
