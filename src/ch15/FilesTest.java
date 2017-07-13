package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scn on 2017/7/13.
 * Files类测试
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        // 复制文件
        Files.copy(Paths.get("src/ch15/FilesTest.java"), new FileOutputStream("src/ch15/a.txt"));
        // 判断FilesTest.java是否为隐藏文件
        System.out.println("filesTest.java是否为隐藏文件:" + Files.isHidden(Paths.get("src/ch15/FilesTest.java")));
        // 一次性读取FilesTest.java文件的所有行
        List<String> lines = Files.readAllLines(Paths.get("src/ch15/FilesTest.java"), Charset.forName("UTF8"));
        System.out.println(lines);
        // 判断指定文件的大小
        System.out.println("FilesTest.java的大小为：" + Files.size(Paths.get("src/ch15/FileTest.java")));
        List<String> poem = new ArrayList<>();
        poem.add("我从崖边跌落");
        poem.add("落入星空辽阔");
        // 直接将多个字符串内容写入指定文件中
        Files.write(Paths.get("src/ch15/a.txt"), poem, Charset.forName("UTF8"));
        // 使用Java8新增的Stream API列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
        // 使用Stream API读取文件内容
        Files.lines(Paths.get("src/ch15/FilesTest.java"), Charset.forName("UTF8")).forEach(line -> System.out.println(line));
        FileStore cStore = Files.getFileStore(Paths.get("/"));
        // 判断总空间、可用空间
        System.out.println(cStore.getTotalSpace());
        System.out.println(cStore.getUsableSpace());
    }
}
