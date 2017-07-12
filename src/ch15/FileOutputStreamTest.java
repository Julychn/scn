package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by scn on 2017/7/12.
 * FileOutputStream测试
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建字节输入流
                FileInputStream fis = new FileInputStream("src/ch15/FileOutputStreamTest.java");
                // 创建字节输出流
                FileOutputStream fos = new FileOutputStream("src/ch15/newFile.txt");
                ) {
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 每读取一次，即写入文件输入流，读了多少，就写多少
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
