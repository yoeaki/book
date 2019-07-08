package Socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Sender01 {

    public static void main(String[] args) throws IOException {

        /**
         * 发送send
         *      1.创建DatagramSocket,随机端口号
         *
         * */

        //1.创建DatagramSocket,随机端口号
        DatagramSocket sender = new DatagramSocket();

        //2.创建datagramSocket[数据包]，指定数据，长度，地址，端口
        String str = "你最近还好吗？";
        byte[] bs = str.getBytes("UTF-8");

        DatagramPacket packet = new DatagramPacket(bs,bs.length,Inet4Address.getByName("192.168.1.102"),5288);

        //使用DatagramSocket发送DatagramPacket
        sender.send(packet);

        sender.close();

    }
}
