package ch09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by scn on 2017/7/7.
 */
public class RightTest {
    // 声明一个泛型方法，该泛型方法中带一个T形参
    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (T ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> ao = new ArrayList<>();
        List<String> as = new ArrayList<>();
        // 下面代码完全正常
        test(as, ao);
    }
}
