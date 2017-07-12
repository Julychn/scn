package ch15;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by scn on 2017/7/12.
 * FileReader测试
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        try (
            // 创建字符输入流
            FileReader fr = new FileReader("src/ch15/FileReaderTest.java")
        ) {
            // 创建一个长度为32的字符数组
            char[] cbuf = new char[32];
            // 用于保存实际读取的字符串
            int hasRead = 0;
            // 使用循环来重复取水的过程
            while ((hasRead = fr.read(cbuf)) > 0) {
                // 取出竹筒中的水滴，将字符数组转换成字符串输入
                System.out.print(new String(cbuf, 0, hasRead));
            }
        }
    }
}
