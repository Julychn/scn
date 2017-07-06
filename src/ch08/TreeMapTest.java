package ch08;

import java.util.TreeMap;

/**
 * Created by scn on 2017/7/6.
 * TreeMap类测试，以自然排序为例
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new RR(3), "轻量级Java EE企业应用实战");
        tm.put(new RR(-5), "疯狂Java讲义");
        tm.put(new RR(9), "疯狂Android讲义");
        System.out.println(tm);
        // 返回该TreeMap的第一个Entry对象
        System.out.println(tm.firstEntry());
        // 返回tm的最后一个key值
        System.out.println(tm.lastKey());
        // 返回tm的比new RR(2)大的最小key值
        System.out.println(tm.higherKey(new RR(2)));
        // 返回tm的比new RR(2)大的最小key-value对
        System.out.println(tm.higherEntry(new RR(2)));
        // 返回该TreeMap的字TreeMap
        System.out.println(tm.subMap(new RR(3), new RR(10)));
    }
}

class RR implements Comparable {
    int count;
    public RR(int count) {
        this.count = count;
    }
    public String toString() {
        return "RR[count:" + count + "]";
    }
    // 根据count来判断两个对象是否相等
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == RR.class) {
            RR r = (RR)obj;
            return r.count == this.count;
        }
        return false;
    }

    // 根据count属性值来判断两个对象的大小
    @Override
    public int compareTo(Object o) {
        RR r = (RR)o;
        return Integer.compare(count, r.count);
    }
}
