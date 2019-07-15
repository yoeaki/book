package nio;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

public class StartNio {

    /**
     * mark 标记位置
     * remaining 可以看缓冲区可以操作的数量
     *
     * */

    @Test
    public void testMark(){

        //创建一个buffer
        ByteBuffer buf = ByteBuffer.allocate(2048);

        String str = "456456afdsafd";
        buf.put(str.getBytes());
        System.out.println(buf.get(10));

        //切换读取状态
        buf.flip();
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,3);
        System.out.println(new String(bytes,0,2));

        //标记信息,记录position
        buf.mark();

        buf.get(bytes,2,2);
        System.out.println(new String(bytes,2,3));
        System.out.println("pos:" + buf.position());
        System.out.println("limt:" + buf.limit());
        System.out.println("capacity:" + buf.capacity());
        System.out.println("---------------------------------");

        buf.reset();
        System.out.println(buf.position());
        System.out.println("---------------------");

        if (buf.hasRemaining()){
            //获取剩余操作的数量
            System.out.println(buf.remaining());
        }


    }

    @Test
    public void testNio(){

        String str = "dafdsa我方";
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());


        System.out.println("=================put进缓冲区================");
        //将数据put进入buffer缓冲区中
        ByteBuffer put = allocate.put(str.getBytes());
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());

        //切换到读取数据
        allocate.flip();

        System.out.println("===================切换模式flip================");
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());

        System.out.println("====================get读数据模式=================");
        byte[] dst = new byte[allocate.limit()];
        allocate.get(dst);
        System.out.println(new String(dst,0,dst.length));

        System.out.println("===================查看读取信息后的指针================");
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());

        System.out.println("====================rewind重复读模式================");
        allocate.rewind();
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());

        System.out.println("====================clear清空缓冲区================");
        allocate.clear();
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());

        System.out.println((char)allocate.get(5));

    }

    @Test
    public void testDirect(){
        ByteBuffer buf = ByteBuffer.allocateDirect(2048);
        //判断是否是直接缓冲区
        System.out.println(buf.isDirect());
    }


    /**
     * java.nio.channels.channel 接口
     *      |--FileChannel      本地
     *      |--SocketChannel    网路TCP
     *      |--ServerSocketCHannel  网络TCP
     *      |--DatagramChannel  网络UDP
     *
     * 1.获取通道Channel
     *      本地IO：
     *          FileInputStream/FileOutStream
     *          RandomAccessFile
     *      网络IO：
     *          Socket
     *          ServerSocket
     *          DatagramSocket
     * 2. 在JDK1.7中的NIO.2针对各个通道提供了静态方法open()获取
     * 3. 在JDK1.7中的NIO.2的Files 工具类的newByteCannel()
     * */
    @Test
    public void testCannel() throws IOException {
        //利用通道完成文件的复制
        FileInputStream fis = new FileInputStream("1.png");
        FileOutputStream fos = new FileOutputStream("2.png");

        //获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel ouChannel = fos.getChannel();

        //分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //将通道数据存入缓冲区中,循环读
        while (inChannel.read(buf) != -1){
            //开启读通道
            buf.flip();

            //写如output
            ouChannel.write(buf);

            //清空缓冲区
            buf.clear();
        }

        ouChannel.close();
        inChannel.close();
        fis.close();
        fos.close();


    }


    /**
     * 使用直接缓冲区完成文件复制（内存映射文件）
     *  F
     *
     * */
    @Test
    public void testDirectChanel() throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel ouChannel = FileChannel.open(Paths.get("3.png"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //下面这个跟ByteBuffer.allocateDirect一模一样，只有ByteBuffer支持,内存映射文件
        MappedByteBuffer inMapperBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer ouMapperBuffer = ouChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //将inMapperBuffer读到ouMapperBuffer中去
        byte[] dst = new byte[inMapperBuffer.limit()];

        ouMapperBuffer.put(dst);

        inChannel.close();
        ouChannel.close();
    }

    /**
     * 通道之间的数据传输
     *      transferform()
     *      transferTo()
     * */
    @Test
    public void testTransfer() throws IOException {
        //开启发送起点（in）和开启接收out通道
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("5.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //开车送去out
        inChannel.transferTo(0,inChannel.size(),outChannel);
        //再开车来接收
        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void testDatagramChannel(){
        /*DatagramChannel.open();
        Selector.open();*/
    }
    @Test
    public void client(){

      /* ByteBuffer buf = ByteBuffer.allocate(2048);

        SocketChannel socketChannel = SocketChannel.open();
        //配置非阻塞行为
        socketChannel.configureBlocking(false);

        socketChannel.connect("ip");

        if (socketChannel.finishConnect()){
            int i = 0;
            TimeUnit.SECONDS.sleep(1);
        }*/

    }

    /**
     * 分散（Scatter）与聚集（Gather）
     *
     */
    @Test
    public void ScatterAndGather() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("E:\\love.txt", "rw");

        //获取通道
        FileChannel channel = raf1.getChannel();

        //分配空间
        ByteBuffer buf1 = ByteBuffer.allocateDirect(100);
        ByteBuffer buf2 = ByteBuffer.allocateDirect(2048);

        //分散读取
        ByteBuffer[] bufs = {buf2,buf1};
        channel.read(bufs);

        for (ByteBuffer byteBuffer:bufs){
            //开启读取通道
            byteBuffer.flip();
        }

        /*System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("--------------------------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));*/

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("nio1.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

    }

    @Test
    public void ScatterAndGather2() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("E:\\love.txt", "rw");
        FileChannel channel = raf.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocateDirect(32);
        ByteBuffer buf2 = ByteBuffer.allocateDirect(30);

        ByteBuffer[] bufs = {buf2,buf1};
        channel.read(bufs);

        for (ByteBuffer byteBuffer:bufs){
            byteBuffer.flip();
        }

        RandomAccessFile raf2 = new RandomAccessFile("nio4.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

        channel.close();
        channel2.close();

    }

    @Test
    public void charset() throws CharacterCodingException {
        /*SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String,Charset> entry:set){
            System.out.println(entry);
        }*/

        Charset gbk = Charset.forName("UTF-8");

        //get encoder
        CharsetEncoder ce = gbk.newEncoder();
        //get decoder
        CharsetDecoder de = gbk.newDecoder();

        String str="没有你的印记";
        //分配buffer
        CharBuffer buf = CharBuffer.allocate(1024);
        buf.put(str);
        buf.flip();
        //编码
        ByteBuffer bbf = ce.encode(buf);
        System.out.println(buf);

        for (int i = 0; i < str.length();i++){
            System.out.println(buf.get(i));
        }
    }

    /**
     * 客户端
     */
    @Test
    public void testClient() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

        //将文件读到通道中
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);

        //分配1024大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);

        while (inChannel.read(buf) != -1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

    }
}



