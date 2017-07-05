package ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scn on 2017/7/5.
 * List常规用法测试
 */
public class ListTest {
    public static void main(String[] args) {
        List books = new ArrayList();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books);
        // 将新字符串插入到第二个位置
        books.add(1, "疯狂Ajax讲义");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        // 删除第三个元素
        books.remove(2);
        System.out.println(books);
        // 判断指定元素在集合中的位置
        System.out.println(books.indexOf(new String("疯狂Ajax讲义")));
        // 将第二个元素替换成新的字符串对象
        books.set(1, new String("疯狂Java讲义"));
        System.out.println(books);
        // 将books集合的第二个元素到第三个元素截取成子集合
        System.out.println(books.subList(1, 2));
    }
}
