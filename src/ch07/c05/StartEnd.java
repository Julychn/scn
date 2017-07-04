package ch07.c05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scn on 2017/7/4.
 */
public class StartEnd {
    public static void main(String[] args) {
        // 创建一个Pattern对象，并用它创建一个Matcher对象
        String regStr = "Java is very good!";
        System.out.println("目标字符串是：" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + "子串的起始位置：" + m.start() + "， 其结束位置是：" + m.end());
        }
    }
}
