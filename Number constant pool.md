## Integer constant pool
### Source code explanation
<p>Cache to support the object identity semantics of autoboxing for values between * -128 and 127 (inclusive) as required by JLS.</p>

****

### My Test
<p>This is a test of Integer constant pool. The number constant pool save much constant number about between -128 and 127. Test</p>

	package day07.test01.demo;
	public class DemoTest {
	    public static void main(String[] args) {
	
	        Integer a = 127;
	        Integer b = 127;
	        System.out.println("127:" + (a==b));    //true
	        /*以上为true
	        * 在创建对象时，首先会查找常量池中是否有这个对象
	        * 而常量池中存了常用的数字常量池范围：-128~127
	        * 所以a和b同时指向了同一个地址，所以a和b的地址一样，所以返回的是true
	        * */
	
	        Integer c = 188;
	        Integer d = 188;
	        System.out.println("188:" + (c==d));    //false
	        /*以上为false
	        * Integer为对象，在分配对象的时候扫描常量池，发现没有变量
	        * 即调用Integer的构造函数 Integer c = new Integer("188");
	        *                        Integer d = new Integer("188");
	        * 对象存在堆内存中的，分配的时候c和d的指向地址都不同所以不等
	        * */
	
	        Integer e = 188;
	        Integer f = 188;
	        System.out.println("188:" + e.equals(f));      //true
	        System.out.println("结果：" + e.equals(e));    //true
	        /*
	        * 可以判断值相等
	        *
	        * */
	
	        String str = "ab";
	        System.out.println("null:" + str.hashCode());   //hashCode3105
	    }
	}

