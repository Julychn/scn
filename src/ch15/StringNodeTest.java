package ch15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by scn on 2017/7/12.
 * 使用字符串作为物理节点的字符输入/输出流
 */
public class StringNodeTest {
    public static void main(String[] args) {
        String src = "从明天起，做一个幸福的人\n"
                + "喂马、劈柴、周游世界\n"
                + "从明天起，关心粮食和蔬菜\n";
        char[] buffer = new char[32];
        int hasRead = 0;
        try (
                StringReader sr = new StringReader(src)
                ) {
            // 采用循环读取的方式读取字符串
            while ((hasRead = sr.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                // 创建StringWriter时，实际上以一个StringBuffer作为输出节点
                // 下面指定的20就是StringBuffer的初始长度
                StringWriter sw = new StringWriter()
                ) {
            // 调用StringWriter的方法执行输出
            sw.write("有一个美丽的新世界，\n");
            sw.write("她在远方等我, \n");
            System.out.println("--下面是sw字符串节点里的内容--");
            // 使用toString方法返回StringWriter字符串节点的内容
            System.out.println(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
