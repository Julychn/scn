package ch06;

import javax.swing.*;

/**
 * 方法引用和构造器引用
 * Created by scn on 2017/6/19.
 */
@FunctionalInterface
interface Converter {
    Integer convert(String from);
}

@FunctionalInterface
interface MyTest {
    String test(String a, int b, int c);
}

@FunctionalInterface
interface YourTest {
    JFrame win(String title);
}

public class MethodRefer {
    public static void main(String[] args) {
        // 1.引用类方法
        // 下面代码使用Lambda表达式创建Converter对象
        Converter converter1 = from -> Integer.valueOf(from);
        Integer val = converter1.convert("99");
        System.out.println(val);
        // 方法引用代替Lambda表达式:引用类方法
        // 函数式接口中被实现方法的全部参数传给该类方法作为参数
        Converter converter2 = Integer::valueOf;
        Integer val2 = converter2.convert("101");
        System.out.println(val2);

        System.out.println("-------------------");

        // 2.引用特定对象的实例方法
        Converter converter3 = from -> "fkit.org".indexOf(from);
        Integer value = converter3.convert("it");
        System.out.println(value);
        // 方法引用代替Lambda表达式：引用特定对象的实例方法
        // 函数式接口中被实现方法的全部参数传给该方法作为参数
        Converter converter4 = "fkit.org"::indexOf;

        System.out.println("-------------------");

        // 3.引用某类对象的实例方法
        // 下面代码使用Lambda表达式床架MyTest对象
        MyTest myTest1 = (a, b, c) -> a.substring(b, c);
        String str = myTest1.test("java I Lova You", 2, 9);
        System.out.println(str);
        // 函数式接口中被实现方法的第一个参数作为调用者
        // 后面的参数全部传给该方法作为参数
        MyTest myTest2 = String::substring;

        System.out.println("-------------------");

        // 4.引用构造器
        YourTest yt1 = a -> new JFrame(a);
        JFrame jf = yt1.win("我的窗口");
        System.out.println(jf);
        // 构造器引用代替Lambda表达式
        // 函数式接口中被实现方法的全部参数传给该构造器作为参数
        YourTest yt2 = JFrame::new;
    }
}
