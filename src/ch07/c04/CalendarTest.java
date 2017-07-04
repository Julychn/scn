package ch07.c04;

import java.util.Calendar;

/**
 * Created by scn on 2017/7/4.
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // 取出年
        System.out.println(calendar.get(Calendar.YEAR));
        // 取出月份
        System.out.println(calendar.get(Calendar.MONTH));
        // 取出日
        System.out.println(calendar.get(Calendar.DATE));
        // 分别设置年、月、日、小时、分钟、秒
        calendar.set(2018, 10, 23, 12, 32, 23);
        System.out.println(calendar.getTime());
        // 将calendar的年前推一年
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.getTime());
        // 将calendar的月前推8个月
        calendar.add(Calendar.MONTH, -8);
        System.out.println(calendar.getTime());
    }
}
