package ch06;

/**
 * Created by July on 2017/6/12.
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        // 生成新的Integer对象
        Integer in1 = new Integer(6);
        // 生成新的Integer对象，并缓存该对象
        Integer in2 = Integer.valueOf(6);
        // 直接从缓存中取出Integer对象
        Integer in3 = Integer.valueOf(6);
        System.out.println(in1 == in2); // 输出false
        System.out.println(in2 == in3); // 输出true
        // Integer只缓存-128-127之间的值
        Integer in4 = Integer.valueOf(200);
        Integer in5 = Integer.valueOf(200);
        System.out.println(in4 == in5); // 输出false
    }
}
