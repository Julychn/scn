package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by scn on 2017/7/12.
 * 转换流
 */
public class KeyinTest {
    public static void main(String[] args) {
        try (
                // 将System.in对象转换成Reader对象
                InputStreamReader reader = new InputStreamReader(System.in);
                // 包装成BufferedReader
                BufferedReader br = new BufferedReader(reader)
                ) {
            String line = null;
            // 采用循环方式来逐行读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为exit，则程序退出
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
