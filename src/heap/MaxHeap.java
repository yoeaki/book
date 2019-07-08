package heap;


public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * 将任意一个数组转换成最大堆形式
     * */

    /*public MaxHeap(E[] arr){
        data = new Array<>(arr);
    }*/

    /**
    * 返回堆中元素的个数
    * */
    public int size(){
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     * */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     *  返回父亲结点的索引
     */
    private  int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index is ilegal.");
        return (index - 1)/2;
    }

    /**
     * 返回左孩子结点的索引
     * */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回右孩子结点的索引
     * */
    private int rightChild(int index){
        return index * 2 + 2;
    }


    /**
     * 向堆中添加元素
     * */
    public void add(E e){
        //Array里面的方法
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 向堆中插入元素，并按照规则排序
     * */
    private void siftUp(int k) {

        //1.判断k是否是根节点，2.判断父节是否小于孩子结点，若小于，则进行交换
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k,parent(k));
            k = parent(k);
        }

    }

    /**
     * 从堆中取出元素
     **/
    public E extractMax(){

        //调用取出最大元素函数
        E ret = findMax();

        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 堆中元素下沉
     * */
    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);

            //判断右孩子是否存在，子节点索引大于左孩子
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }

            //判断当前结点是否大于孩子结点值
            if (data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            //否这进行交换
            data.swap(k,j);

            k = j;
        }
    }

    /**
     * 看堆中的最大元素
     * */
    public  E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }



}