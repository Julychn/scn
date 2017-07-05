package ch08;

import java.util.TreeSet;

/**
 * Created by scn on 2017/7/5.
 * TreeSet定制排序测试
 */
class M {
    int age;
    public M(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "M [age:" + age + "]";
    }
}
public class TreeSetTest4 {
    public static void main(String[] args) {
        // 此处Lambda表达式的目标类型是Comparator
        TreeSet ts = new TreeSet((o1, o2) -> {
            M m1 = (M)o1;
            M m2 = (M)o2;
            // 根据M对象的age属性来决定大小,age越大，M对象反而越小
            if (m1.age > m2.age) {
                return -1;
            } else if (m1.age < m2.age) {
                return 1;
            } else {
                return 0;
            }
        });
        ts.add(new M(5));
        ts.add(new M(10));
        ts.add(new M(-5));
        System.out.println(ts);
    }
}
