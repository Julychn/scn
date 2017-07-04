package ch07.c04;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by scn on 2017/7/4.
 */
public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date();
        // 获取当前时间之后100ms的时间
        Date d2 = new Date(System.currentTimeMillis() + 10000);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));

        // 创建一个默认的Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 从Calendar对象中取出Date对象
        Date date = calendar.getTime();
        // 通过Date对象获得对应的Calendar对象，因为Calendar没有构造函数可以接受Date对象。必须先获得一个Calendar实例，然后调用setTime
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
    }
}
