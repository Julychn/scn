package ch15;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by scn on 2017/7/12.
 * 使用RandomAccessFile向文件中追加内容
 */
public class AppendContent {
    public static void main(String[] args) {
        try (
                // 以读写模式打开一个文件
                RandomAccessFile raf = new RandomAccessFile("src/ch15/out.txt", "rw")
                ) {
            // 将记录指针移动到out.txt文件的最后
            raf.seek(raf.length());
            raf.write("追加的内容！\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
