package ch15;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by scn on 2017/7/13.
 * 使用WatchService监控文件变化
 */
public class WatchServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取文件系统的WatchService对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 为src/ch15路径注册监听
        Paths.get("src/ch15").register(watchService,
                ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        while(true) {
            // 获取下一个文件变化事件
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + " 文件发生了 " + event.kind() + " 事件！");
            }
            // 重设WatchKey
            boolean valid = key.reset();
            // 如果重设失败，退出监听
            if (!valid) {
                break;
            }
        }
    }
}
