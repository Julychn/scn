package ch08;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by scn on 2017/7/5.
 * 使用Lambda表达式来遍历Iterator
 */
public class IteratorEach {
    public static void main(String[] args) {
        // 创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        // 获取books对应的迭代器
        Iterator i = books.iterator();
        // 使用Lambda表达式（目标类型是Comsumer）来遍历集合元素
        i.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
