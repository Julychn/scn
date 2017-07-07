package ch09;

/**
 * Created by scn on 2017/7/7.
 * 定义泛型构造器
 */
public class GenericConstructor {
    public static void main(String[] args) {
        // 泛型构造器中的参数为Integer
        new Foo(200);
        // String
        new Foo("疯狂Java讲义");
        // 显示指定泛型构造器中的T参数为String
        // 传给Foo构造器的参数也是String对象，完全正确
        new <String> Foo("疯狂Android讲义");

    }
}
class Foo {
    public <T> Foo(T t) {
        System.out.println(t);
    }
}
