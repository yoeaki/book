package GUI;

import java.io.*;
import java.net.Socket;

public class ClinetDemo {

    public static void main(String[] args)
            throws IOException {

        /**
         *
          * @Description TODO
         * @date 2019/6/3 14:00
         * @params [args]
         * @return void
         * @Exception
         * 客户端
         *
         */

        //1.创建Socket对象，传入主机，端口号
        Socket socket = new Socket("127.0.0.1",9999);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os);

        //3.发送数据到服务器
        pw.write("java非常不错！");

        //关闭
        br.close();
        socket.close();
    }
}
