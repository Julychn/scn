package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by scn on 2017/7/12.
 * 使用PrintStream来包装OutputStream
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("src/ch15/test.txt");
                PrintStream ps = new PrintStream(fos)
                ) {
            // 使用PrintStream来执行输出
            ps.println("普通字符串");
            // 直接使用PrintStream输出对象
            ps.println(new PrintStreamTest());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
