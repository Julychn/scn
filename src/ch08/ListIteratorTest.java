package ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by scn on 2017/7/5.
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "疯狂Java讲义", "疯狂iOS讲义",
                "轻量级Java EE企业应用实战"
        };
        List bookList = new ArrayList();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("---------分隔符---------");
        }
        System.out.println("=========下面开始反向迭代==========");
        while(lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
