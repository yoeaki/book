package ThirdDay;

public class Expansion {

    public String[] expansion(String[] arr, String element){

        //扩容标识符
        boolean flag = true;

        //定义一个新数组
        String[] nameArray = arr;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                arr[i] = element;
                flag = false;
                break;
            }
        }

        if (flag){
            String[] newArray = new String[arr.length + 1];

            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }

            arr = newArray;
        }

        return arr;
    }
}
