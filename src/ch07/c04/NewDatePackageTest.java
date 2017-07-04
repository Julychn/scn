package ch07.c04;

import java.time.*;

/**
 * Created by scn on 2017/7/4.
 * java8 新增的java.time包测试
 */
public class NewDatePackageTest {
    public static void main(String[] args) {
        // 下面是关于Clock类的用法
        // 获取当前Clock
        Clock clock = Clock.systemUTC();
        // 通过Clock获取当前时间
        System.out.println("当前时刻为：" + clock.instant());
        // 获取对应的毫秒数，与System.currentTimeMillis()输出相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        // 下面是关于Duration的用法
        Duration d  = Duration.ofSeconds(6000);
        System.out.println("6000秒相当于：" + d.toMinutes() + "分，" + d.toHours() + "小时，" + d.toString() + "天");
        // 在clock基础上增加6000秒，返回新的clock
        Clock clock2 = Clock.offset(clock, d);
        System.out.println("当前时刻加6000秒为：" + clock2.instant());

        // 下面是关于Instance的用法
        // 获取当前时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // 添加6000秒，返回新的instant
        Instant instant1 = instant.plusSeconds(6000);
        System.out.println(instant1);
        // 根据字符串解析Instant对象
        Instant instant2 = instant.parse("2017-07-04T13:18:09.234Z");
        System.out.println(instant2);
        // 在instant2的基础上增加5小时4分钟
        Instant instant3 = instant2.plus(Duration.ofHours(5).plusMillis(4));
        System.out.println(instant3);
        // 获取instant3的5天前的时刻
        Instant instant4 = instant3.minus(Duration.ofDays(5));
        System.out.println(instant4);

        // 下面是关于LocalDate的用法
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 获得2014年的第146天
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate);
        // 设置为2014年5月21日
        localDate = LocalDate.of(2014, Month.MAY, 21);
        System.out.println(localDate);

        // 下面是关于LocalTime的用法
        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // 设置为22点33分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        // 返回一天中的第5503秒
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);

        // 下面是关于localDateTime的用法
        // 获取当前日期、时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 当前日期、时间加上25小时3分钟
        LocalDateTime future = localDateTime.plus(Duration.ofHours(25).plusMinutes(3));
        System.out.println(future);
        // 另一种方法
        LocalDateTime future2 = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(future2);

        // 下面是关于Year、YearMonth、MonthDay的用法示例
        Year year = Year.now();     // 获取当前年份
        System.out.println(year);
        // 当前年份加5
        year = year.plusYears(5);
        System.out.println(year);
        // 根据指定月份获取YearMonth
        YearMonth yearMonth = year.atMonth(10);
        System.out.println(yearMonth);
        // 当前年月再加5年、减3个月
        yearMonth = yearMonth.plusYears(5).minusMonths(3);
        System.out.println(yearMonth);
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        // 设置为5月23日
        monthDay = monthDay.with(Month.MAY).withDayOfMonth(23);
        System.out.println(monthDay);
    }
}
