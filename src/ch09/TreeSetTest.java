package ch09;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by scn on 2017/7/7.
 * 使用通配符下限的方式定义TreeSet构造器的参数
 */
public class TreeSetTest {
    public static void main(String[] args) {
        // Comparator的实际类型是TreeSet的元素类型的父类，满足要求
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return hashCode() > o2.hashCode() ? 1 : hashCode() < o1.hashCode() ? -1 : 0;
            }
        });
        ts1.add("hello");
        ts1.add("wa");
        // Comparator的实际类型是TreeSet元素的类型，满足要求
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1 : o1.length() < o2.length() ? 1 : 0;
            }
        });
        ts2.add("hello");
        ts2.add("wa");
        System.out.println(ts1);
        System.out.println(ts2);
    }
}
