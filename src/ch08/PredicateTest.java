package ch08;


import java.util.Collection;
import java.util.HashSet;

/**
 * Created by scn on 2017/7/5.
 * 使用Java8新增的Predicate操作集合
 */
public class PredicateTest {
    public static void main(String[] args) {
        // 创建一个集合
        Collection books = new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂iOS讲义"));
        books.add(new String("疯狂Ajax讲义"));
        books.add(new String("疯狂Android讲义"));
        // 使用Lambda表达式（目标类型是Predicate）过滤集合
        books.removeIf(ele -> ((String)ele).length() < 10);
        System.out.println(books);
    }
}
