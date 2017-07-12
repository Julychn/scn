package ch15;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by scn on 2017/7/12.
 * 使用RandomAccessFile类读取文件
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                RandomAccessFile raf = new RandomAccessFile(
                        "src/ch15/RandomAccessFileTest.java", "r")
                ) {
            // 获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("指针初始位置：" + raf.getFilePointer());
            // 移动指针的位置
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
