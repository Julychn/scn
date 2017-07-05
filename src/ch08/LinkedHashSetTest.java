package ch08;

import java.util.LinkedHashSet;

/**
 * Created by scn on 2017/7/5.
 * LinkedHashSet类测试
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("疯狂Java讲义");
        books.add("轻量级Java EE企业应用实战");
        // 输出
        System.out.println(books);
        // 删除一个元素
        books.remove("疯狂Java讲义");
        // 重新添加
        books.add("疯狂Java讲义");
        // 输出，发现是按添加顺序输出的
        System.out.println(books);
    }
}
