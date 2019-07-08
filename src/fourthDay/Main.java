package fourthDay;

import static fourthDay.Father.father;

public class Main {

    public static void main(String[] args) {

        Father st = new Student("123","dsf","henry",18);
        Student st2 = new Student();

        int[][] arr = {{1,21,45,45},{45,21,45,78}};
        int[][] arr2 = {{1,21,45,45},{45,21,45,78}};
        for (int[] a:arr){
            System.out.println(a);
        }
        for (int[] a:arr2){
            System.out.println(a);
        }

        st.run();

        st.run();
        ((Student) st).eat();
        System.out.println(Father.money);
        Father.color = "哈哈";

        System.out.println(st2.sex);
        System.out.println(st.sex);

        System.out.println(Father.color);
    }
}
