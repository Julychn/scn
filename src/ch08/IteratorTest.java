package ch08;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by scn on 2017/7/5.
 * 通过Iterator接口来遍历集合元素
 */
public class IteratorTest {
    public static void main(String[] args) {
        // 创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        // 获取books集合对应的迭代器
        Iterator iterator = books.iterator();
        while (iterator.hasNext()) {
            // iterator.next()方法返回的数据类型是Object类型，需要强制转换
            String book = (String)iterator.next();
            System.out.println(book);
            if (book.equals("疯狂Java讲义")) {
                // 从集合中删除上一次next()方法返回的元素
                iterator.remove();
            }
            // 对book变量赋值不会改变集合元素本身
            book = "测试字符串";
        }
        System.out.println(books);
    }
}
