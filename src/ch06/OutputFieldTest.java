package ch06;

/**
 * Created by July on 2017/6/12.
 */
public class OutputFieldTest {
    public static void main(String[] args) {
        // 访问Output接口的MAX_CACHE_LINE
        System.out.println(Output.MAX_CACHE_LINE);
        // 使用接口来调用类方法
        System.out.println(Output.staticTest());
    }
}
