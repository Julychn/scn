package ch07.c01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by scn on 2017/7/3.
 */
public class ScannerFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        // 将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
        Scanner scanner = new Scanner(new File("ScannerKeyBoardTest.java"));
        System.out.println("ScannerFileTest.java文件的内人如下：");
        // 判断是否还有下一行
        while (scanner.hasNextLine()) {
            // 输出文件中的下一行
            System.out.println(scanner.nextLine());
        }
    }
}
