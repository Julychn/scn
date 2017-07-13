package ch15;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by scn on 2017/7/13.
 * 使用FileVisitor来遍历文件和目录
 */
public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
        // 遍历src目录下的所有文件和目录
        Files.walkFileTree(Paths.get("src"), new SimpleFileVisitor<Path>() {
            // 访问文件时触发该方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问" + file + "文件");
                // 找到了FileVisitorTest.java文件
                if (file.endsWith("FileVisitorTest.java")) {
                    System.out.println("--已经找到目标文件--");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
            // 开始访问目录时触发该方法
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问：" + dir + " 路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
