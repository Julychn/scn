package ch07.c01;

import java.util.Scanner;

/**
 * Created by scn on 2017/7/2.
 */
public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        // System.in代表标准输入，就是键盘输入
        Scanner sc = new Scanner(System.in);
        // 增加下面一行将只把回车作为分隔符，默认分隔符为空格
//        sc.useDelimiter("\n");
        // 判断是否还有下一个输入项
        while (sc.hasNext()) {
            // 输出输入项
            System.out.println("键盘输入的结果是：" + sc.next());
        }
    }
}
