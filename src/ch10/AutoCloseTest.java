package ch10;

import java.io.*;

/**
 * Created by scn on 2017/7/7.
 * 使用自动关闭资源的try语句
 */
public class AutoCloseTest {
    public static void main(String[] args) {
        try (
                // 申明、初始化两个可关闭的资源，try语句会自动关闭这两个资源
                BufferedReader br = new BufferedReader(new FileReader("src/ch10/AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("src/ch10/a.txt"))
                )
        {
            // 使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        } catch (IOException ioe) {
            System.out.println("IO异常：" + ioe.getMessage());
        }
    }
}
