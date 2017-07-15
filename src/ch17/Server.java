package ch17;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by scn on 2017/7/15.
 * 服务器端程序
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket，用于监听客户端的连接请求
        ServerSocket ss = new ServerSocket(30000);
        // 采用循环不断地接受来自客户端的请求
        while(true) {
            // 每当接受到客户端的Socket请求时，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            // 将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            // 进行普通IO操作
            ps.println("您好，您收到了服务器的新年祝福！");
            ps.close();
            s.close();
        }
    }
}
