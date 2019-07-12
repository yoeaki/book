# 增强for循环（foreach）和Iterator迭代器的比较
##1.foreach简单的比较思路
> + 1、定义一个list集合，往里面添加数据

	List<Integer> list = new ArrayList();

		for (int i = 0 ; i<1000000; i++){
		    list.add(i);
		}
> + 2、通过System.currentTimeMillis()获取当前时间star

	long forNowTime = System.currentTimeMillis();
> + 3、用增强for循环进行遍历

	for (Integer integer:list){
            System.out.print(integer);
        }
> + 4、再次获取for循环结束时间end

	long forEndTime = System.currentTimeMillis();
> + 5、相减得到时间差，与迭代器使用的时间进行对比

## 2.迭代器（iterator）

> + 获取迭代器且使用迭代器遍历

	Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

## 3.时间比较总结
> + 当遍历的数量少的时候Iterator比Foreach效率高些，
> + 当遍历数量多时，Foreach比Iterator的效率高
> + 两者都是通过迭代器来遍历，所以时间相差并不大

## 4.补充
使用增强for循环和迭代器遍历时候，不能修改它本身的长度，比如删除和增加。


