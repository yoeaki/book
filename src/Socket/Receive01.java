package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive01 {

    public static void main(String[] args) throws IOException {

        /**
         * 接收Receive
         * 创建DatagramSocket，指定端口号
         *
        * */

        //创建DatagramSocket，指定端口号
        DatagramSocket receiver = new DatagramSocket(5288);

        //定义一个字节大小
        byte[] buf = new byte[1024];

        //创建DatagramPacket,
        DatagramPacket packet = new DatagramPacket(buf, 1024);

        //接收方
        receiver.receive(packet);

        //关闭Socket通道
        receiver.close();

        //从DatagramPacket中取出数据
        String s = new String(buf,0,packet.getLength(),"UTF-8");
        System.out.println("数据：" + s);
    }
}
