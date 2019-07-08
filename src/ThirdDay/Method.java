package ThirdDay;

public class Method {

    /**
     *
     * @Description TODO
     * @date 2019/6/5 9:15
     * @params [arr]
     * @return int
     * @Exception
     */
    public int getMax(int[] arr){

        int max = arr[0];

        for (int a:arr){
            if (a > max){
                max = a;
            }
        }
        return max;
    }

    /**
     *
     * @Description TODO
     * @date 2019/6/5 9:18
     * @params [arr]
     * @return int
     * @Exception
     */
    public int getMin(int[] arr){
        int min = arr[0];

        for (int a:arr){
            if (a < min){
                min = a;
            }
        }
        return min;
    }

    /**
     *
     * @Description TODO
     * @date 2019/6/5 9:27
     * @params [arr, num]
     * @return void
     * @Exception
     */
    public void findByNum(int[] arr,int num){

        for (int i = 0;i < arr.length; i++){
            if (arr[i] == num){
                System.out.println("恭喜你找到了,它在第" + (i+1) + "个元素");
                return;
            }
        }
        System.out.println("次数组没有此元素");
    }

    /**
     *
     * @Description 添加元素和扩充数组
     * @date 2019/6/5 14:48
     * @params [arr, num]
     * @return int[]
     * @Exception
     */
    public int[] add(int[] arr, int num ){

        //计算数组的空值
        int i = 0;
        for (int a : arr){
            if (a != 0){
                i ++;
            }
        }

        //若达到数组设定大小，进行扩容和复制到新数组
        if (i == arr.length){
            int[] change = new int[arr.length + 1];

            for (int j = 0; j < arr.length; j++){
                change[j] = arr[j];
            }

            return addElement(change,num);
        }else {
            return addElement(arr,num);
        }
    }

    public int[] addElement(int[] arr, int num){
        for (int k = 0; k < arr.length; k++){
            if (arr[k] == 0){
                arr[k] = num;
                break;
            }
        }
        return arr;
    }

    /**
     *
     * @Description 对数组进行排序
     * @date 2019/6/5 14:48
     * @params [arr]
     * @return void
     * @Exception
     */
    public void sort(int[] arr){

        int swap = arr[0];

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }

        System.out.println("排序:");
        for (int a : arr){
            System.out.println( a);
        }
    }
}
