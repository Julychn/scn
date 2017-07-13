package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by scn on 2017/7/13.
 * 使用FileLock锁定文件
 */
public class FileLockTest {
    public static void main(String[] args) {
        try (
                // 使用FileOutputStream获取FileChannel
                FileChannel channel = new FileOutputStream("src/ch15/test.txt").getChannel();
                ) {
            // 使用非阻塞方式对指定文件加锁
            FileLock lock = channel.tryLock();
            // 程序暂停10秒
            Thread.sleep(10000);
            // 释放锁
            lock.release();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
