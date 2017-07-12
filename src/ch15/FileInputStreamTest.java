package ch15;


import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by scn on 2017/7/12.
 * FileInputStream测试
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流
        FileInputStream fis = new FileInputStream("src/ch15/FileInputStreamTest.java");
        // 创建一个长度为1024的竹筒
        byte[] bbuf = new byte[1024];
        // 用于保存实际读取的字节数
        int hasRead = 0;
        // 使用循环来重复取水的过程
        while ((hasRead = fis.read(bbuf)) > 0) {
            // 取出竹筒中的水滴（字节），将字节数组转换成字符串输入
            System.out.print("tag" + new String(bbuf, 0, hasRead));
        }
        // 关闭文件输入流，放在finally块里更安全
        fis.close();
    }
}
