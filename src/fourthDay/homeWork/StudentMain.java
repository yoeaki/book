package fourthDay.homeWork;

public class StudentMain {

    public static void main(String[] args) {

        Student student = new Student("admin",'男',78.00,91.00,48.22);
        Student student2 = new Student("admin",23,'男',78.00,91.00,48.22);

        System.out.println(student.toString());
        System.out.println(student2.toString());



        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");

        System.out.println("第一名学生的总分：" + df.format(student.getAll()));
        System.out.println("第一名学生的平均分：" + df.format(student.getAvg()));
    }
}
