package ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by scn on 2017/7/12.
 * 重定向标准输出流
 */
public class RedirectOut {
    public static void main(String[] args) {
        try (
                // 一次性创建PrintStream输出流
                PrintStream ps = new PrintStream(new FileOutputStream("src/ch15/out.txt"))
                ) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            // 向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
