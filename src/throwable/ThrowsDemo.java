package throwable;

public class ThrowsDemo {
    public static void main(String[] args) throws Exception {

        /**
         * 自己处理异常
         *      1. try  catch
         *      2. try catch catch
         *      3. throws
         *          throw new Exception("异常信息")，和在方法上throws Exception搭配使用
         *          throw完后将创建的异常信息给Exception处理
         *          throw后面的内容不会被执行
         * */
        Person p1 = new Person();
        p1.setAge(-18);
        System.out.println(p1.getAge());

    }
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        //年龄0~100岁
        int Max = 100;
        if (age > 0 && age < Max) {
            this.age = age;
        } else {
            throw new Exception("年龄不符合事实");
        }
        System.out.println("我看是否可以执行");
    }
}
