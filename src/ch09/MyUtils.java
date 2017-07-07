package ch09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by scn on 2017/7/7.
 * 设定通配符下限
 */
public class MyUtils {
    // 下面dest集合元素的类型必须与src集合元素的类型相同，或是其父类
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(5);
        // 此处课准确地知道最后一个被复制的元素是Integer类型
        // 与src集合元素的类型相同
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
