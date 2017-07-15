package ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by scn on 2017/7/15.
 * 负责读取Socket输入流中的内容，并将这些内容在控制台打印出来
 */
public class ClientThread implements Runnable {
    // 该线程负责处理的Socket
    private Socket socket;
    // 该线程所处理的Socket对应的输入流
    BufferedReader br = null;
    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            // 不断地读取socket中的内容，并将这些内容打印输出
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
