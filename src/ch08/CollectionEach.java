package ch08;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by scn on 2017/7/5.
 * 使用Lambda表达式来遍历集合元素
 */
public class CollectionEach {
    public static void main(String[] args) {
        // 创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        // 调用forReach()方法遍历集合
        books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
