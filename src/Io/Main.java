package Io;

import date.DateDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] arg){

        DateDemo dateDemo = new DateDemo();
        dateDemo.transForm();
        List<String> list = new ArrayList<>();
        list.add("我爱你");
        Test test = new Test();
        /*try{

            int x = test.division(10,0);
            System.out.println(x);
        }catch (Exception e){
            System.out.println(e);
        }*/
        test.split("wo ai ni");

        /*try{
            int[] arr = {1,2,3,4};
            *//*arr = null;*//*
            System.out.println(arr[4]);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            //一定执行，最后一口气完成遗愿
        }*/

    }
}
