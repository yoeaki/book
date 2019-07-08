package ThirdDay;

public class SortDemo {

    public static void main(String[] args) {

        /**
         * 排序
         *      冒泡：从小到大
         *            从大到小
         *       快速排序
         * */

        int[] arr = {213,34,463,98,87,0};

        int t = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;j < arr.length - i;j++){
                if (arr[i] > arr[j]){
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        for (int a:arr){
            System.out.println(a);
        }
    }

    public static void swap(int max,int min){
        int t = max;
        t = max;
        max = min;
        min = t;
    }
}
