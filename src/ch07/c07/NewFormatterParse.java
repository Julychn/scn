package ch07.c07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by scn on 2017/7/4.
 */
public class NewFormatterParse {
    public static void main(String[] args) {
        // 定义一个任意格式的日期、时间字符串
        String str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        // 执行解析
        LocalDateTime time = LocalDateTime.parse(str1, formatter);
        System.out.println(time);

        // 下面代码再次解析另一个字符串
        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy$$$MMM$$$dd HH小时");
        LocalDateTime time1 = LocalDateTime.parse(str2, dateTimeFormatter);
        System.out.println(time1);
    }
}
