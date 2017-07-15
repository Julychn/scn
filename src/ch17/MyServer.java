package ch17;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by scn on 2017/7/15.
 * 创建ServerSocket监听的主类
 */
public class MyServer {
    // 定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            // 此行代码会阻塞，一直等待别人连接
            Socket s = ss.accept();
            socketList.add(s);
            // 每当客户端连接后启动一个ServerThread线程为该客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
}
