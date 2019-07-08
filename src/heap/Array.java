package heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Array<E>  {

    //定义data
    private E[] data;

    private int size;


    /**
     *
     * @Description 构造函数
     * @date 2019/6/9 15:02
     * @params [capcity]
     * @return
     * @Exception
     */
    public Array(int capcity){
        data = (E[]) new  Object[capcity];
        size = 0;
    }



    /**
     *
     * @Description 无参构造函数，默认数组的容量为capacity = 10
     * @date 2019/6/9 15:02
     * @params []
     * @return
     * @Exception
     */
    public Array(){
        this(10);
    }

    /**
     *
     * @Description 获取数组中的元素个数
     * @date 2019/6/9 15:02
     * @params []
     * @return int
     * @Exception
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @Description 判断数组是否为空
     * @date 2019/6/9 15:03
     * @params []
     * @return boolean
     * @Exception
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @Description 向最后一个元素添加新元素
     * @date 2019/6/9 15:01
     * @params [e]
     * @return void
     * @Exception
     */
    public  void addLast(E e){
        add(size,e);
    }

    /**
     * @Description 在数组中首位添加新元素
     * @date 2019/6/9 15:16
     * @params [e]
     * @return void
     * @Exception
     */
    public  void addFirst(E e){
        add(0,e);
    }

    /**
     *
     * @Description 在index里面添加一个新元素
     * @date 2019/6/9 15:01
     * @params [index, e]
     * @return void
     * @Exception
     */
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed!");
        }

        //如果现在的数组已经装满
        if (size == data.length) {
            //扩容
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     *
     * @Description 通过索引获取元素
     * @date 2019/6/9 15:03
     * @params [index]
     * @return E
     * @Exception
     */
    public E get(int index){
        if (index < 0 && index >= size){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data[index];
    }

    /**
     *
     * @Description 改变数组中某个索引的值
     * @date 2019/6/9 15:35
     * @params [index, e]
     * @return void
     * @Exception
     */
    public void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set is failed,index is Illegal.");
        data[index] = e;
    }

    /**
     *
     * @Description 查看数组中是否存在该元素e
     * @date 2019/6/9 15:44
     * @params [e]
     * @return boolean
     * @Exception
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     *
     * @Description 查找该元素所在位置的索引，不存在返回-1
     * @date 2019/6/9 15:47
     * @params [e]
     * @return int
     * @Exception
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failde.Index is Illegal");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null;

        if (size == data.length / 2)
            resize(size);
        return ret;
    }

    /**
     *
     * @Description 删除第一个元素
     * @date 2019/6/9 16:35
     * @params []
     * @return E
     * @Exception
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     *
     * @Description 删除最后一个元素
     * @date 2019/6/9 16:59
     * @params []
     * @return E
     * @Exception
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     *
     * @Description 删除指定元素e
     * @date 2019/6/9 17:03
     * @params [e]
     * @return void
     * @Exception
     */
    public void removeElement(E e){
        int index = find(e);

        if (find(e) != -1)
            remove(index);
    }

    /**
     *
     * @Description 元素交换
     * @date 2019/6/9 15:03
     * @params [i, j]
     * @return void
     * @Exception
     */
    public void swap(int i, int j){
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        //数值交换
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            //将旧数组赋值到新的数组里面
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     *
     * @Description 前后两个数是否低于0或者最大
     * @date 2019/6/9 15:28
     * @params [i, j]
     * @return void
     * @Exception
     */
    private void getIllegal(int i, int j){
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
    }

    /**
     *
     * @Description 判断这个数是否超出数组范围
     * @date 2019/6/9 15:28
     * @params [index]
     * @return void
     * @Exception
     */
    private void getIllegal(int index){
        if (index < 0 && index >= size){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i =0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
}
