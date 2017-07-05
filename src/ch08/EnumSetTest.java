package ch08;

import java.util.EnumSet;

/**
 * Created by scn on 2017/7/5.
 * 使用EnumSet类保存枚举类的多个实例
 */
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
public class EnumSetTest {
    public static void main(String[] args) {
        // 创建一个EnumSet集合，集合元素是Season枚举类的全部枚举值
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);
        // 创建一个EnumSet空集合，指定其集合元素是Season类的枚举值
        EnumSet es2 = EnumSet.noneOf(Season.class);
        System.out.println(es2);
        // 手动添加两个元素
        es2.add(Season.AUTUMN);
        es2.add(Season.SPRING);
        System.out.println(es2);
        // 以指定枚举值创建EnumSet集合
        EnumSet es3 = EnumSet.of(Season.SPRING, Season.AUTUMN);
        System.out.println(es3);
        EnumSet es4 = EnumSet.complementOf(es3);
        System.out.println(es4);
    }
}
