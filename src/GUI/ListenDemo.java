package GUI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ListenDemo {

    /**
     *
     * @author yoeaki
     * @Classname ListenDemo
     * @Description TODO
     * @date 2019/6/3 13:43
     */
    public static void main(String[] args)
            throws IOException {

        /**
         * 服务端
         * */
        /**
         *
         * @author yoeaki
         * @creed: Talk is cheap,show me the code
         * @date 2019/6/3 13:31
         * @params [args]
         * @return void
         */

        //创建服务器Socket对象
        ServerSocket serverSocket = new ServerSocket(9999);

        //监听客户端连接
        while (true){
            Socket clientSocket = serverSocket.accept();

            //3.开启一个线程
            new Thread(){
                @Override
                public void run() {


                    try {
                        //读写数据通过IO流
                        InputStream is = clientSocket.getInputStream();
                        OutputStream os = clientSocket.getOutputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintWriter pw = new PrintWriter(os);

                        //读数据
                        while (true){
                            String line = br.readLine();
                            if (line != null){
                                System.out.println(new Date() + "接收到客户端发送的数据" + line);

                                //响应客户端
                                pw.write("我接收到了客户端发送的数据\r\n");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    //读取客户端数据
                }
            }.start();
        }
    }
}
