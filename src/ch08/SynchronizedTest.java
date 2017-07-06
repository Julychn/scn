package ch08;

import java.util.*;

/**
 * Created by scn on 2017/7/6.
 * Collections类中提供了多个sysnchronizedXxx()方法，用于将制定集合包装成线程同步的集合
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        // 下面程序创建了4个线程安全的集合对象
        Collection c = Collections.synchronizedCollection(new ArrayList<>());
        List list = Collections.synchronizedList(new ArrayList<>());
        Set set = Collections.synchronizedSet(new HashSet<>());
        Map map = Collections.synchronizedMap(new HashMap<>());
    }
}
