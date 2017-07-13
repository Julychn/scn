package ch15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by scn on 2017/7/13.
 */
public class RandomFileChannelTest {
    public static void main(String[] args) {
        File file = new File("src/ch15/newFile.txt");
        try (
                // 创建一个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                // 获取RandomAccessFile对应的channel
                FileChannel randomChannel = raf.getChannel()
                ) {
            // 将Channel中的所有数据映射成ByteBuffer
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
            // 把Channel的记录指针移动到最后
            randomChannel.position(file.length());
            // 将buffer的所有数据输出
            randomChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
