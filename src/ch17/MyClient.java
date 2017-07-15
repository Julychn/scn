package ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by scn on 2017/7/15.
 * 负责读取用户键盘输入
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        // 客户端启动ClientThread线程不断地读取来自服务器的数据
        new Thread(new ClientThread(socket)).start();
        // 获取该Socket对应的输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String line = null;
        // 不断地读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            // 将用户的键盘输入内容写入到Socket对应的输出流
            ps.println(line);
        }
    }
}
