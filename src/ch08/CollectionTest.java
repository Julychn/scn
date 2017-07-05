package ch08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by scn on 2017/7/5.
 * Collection集合基本操作测试
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        // 添加元素
        c.add("孙悟空");
        // 虽然集合里不能放基本类型的值，但Java支持自动装箱
        c.add(6);
        System.out.println("c集合的元素个数为：" + c.size());
        // 删除指定元素
        c.remove(6);
        System.out.println("c集合的元素个数为：" + c.size());
        // 判断是否包含指定字符串
        System.out.println(c.contains("孙悟空"));
        c.add("轻量级Java EE企业应用实战");
        System.out.println("c集合的元素：" + c);
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        System.out.println("c集合是否完全包含books集合：" + c.contains(books));
        // 用c集合减去books集合里的元素
        c.removeAll(books);
        System.out.println("c集合里的元素：" + c);
        // 删除c集合里的所有元素
        c.clear();
        System.out.println("c集合里的元素：" + c);
        // 控制books集合里只剩下c集合里也包含的元素
        books.retainAll(c);
        System.out.println("books集合里的元素：" + books);
    }
}
