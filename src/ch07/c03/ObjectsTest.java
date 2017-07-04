package ch07.c03;

import java.util.Objects;

/**
 * Created by scn on 2017/7/3.
 */
public class ObjectsTest {
    // 定义一个obj变量，默认值为null
    private static ObjectsTest obj;
    public static void main(String[] args) {
        // 输出一个null对象的hashcode值，输出0
        System.out.println(Objects.hashCode(obj));
        // 输出一个null对象的toString，输出null
        System.out.println(Objects.toString(obj));
        // 要求obj不能为null，如果为null则引发异常
        System.out.println(Objects.requireNonNull(obj, "obj的参数不能为null！"));
    }
}
