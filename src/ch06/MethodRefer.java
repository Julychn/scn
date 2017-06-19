package ch06;

/**
 * 定义一个函数式接口
 * Created by scn on 2017/6/19.
 */
@FunctionalInterface
interface Converter {
    Integer convert(String from);
}

public class MethodRefer {
    public static void main(String[] args) {
        // 下面代码使用Lambda表达式创建Converter对象
        Converter converter1 = from -> Integer.valueOf(from);
        Integer val = converter1.convert("99");
        System.out.println(val);

    }
}
