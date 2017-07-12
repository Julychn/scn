package ch15;

import java.io.File;

/**
 * Created by scn on 2017/7/12.
 * 文件过滤器 FilenameFilter
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        // 使用Lambda表达式实现文件过滤器
        // 如果文件名以.java结尾，或者文件对应一个路径，返回true
        String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        if (nameList != null) {
            for (String name : nameList) {
                System.out.println(name);
            }
        }
    }
}
