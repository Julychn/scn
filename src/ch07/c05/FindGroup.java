package ch07.c05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scn on 2017/7/4.
 */
public class FindGroup {
    public static void main(String[] args) {
        // 使用字符串模拟从网络上得到的网页源码
        String str = "我想求购一本《疯狂Java讲义》，尽快联系我13500006666"
                + "交朋友，号码是13611112222"
                + "出售二手笔记本，联系方式15899990000";
        // 创建一个Pattern对象，并用它建立一个Mathcher对象
        // 该正则表达式只抓取13X和15X段的号码
        // 实际要抓取哪些电话号码，只要修改正则表达式即可
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        // 将所有符合正则表达式的子串全部输出
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
