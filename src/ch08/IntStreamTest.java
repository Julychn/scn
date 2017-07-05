package ch08;

import java.util.stream.IntStream;

/**
 * Created by scn on 2017/7/5.
 */
public class IntStreamTest {
    public static void main(String[] args) {
        IntStream intStream = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        // 下面调用聚集方法的代码每次只能执行一次
        System.out.println("intStream所有元素的最大值：" + intStream.max().getAsInt());
        System.out.println("intStream所有元素的最小值：" + intStream.min().getAsInt());
        System.out.println("intStream所有元素的总和：" + intStream.sum());
        System.out.println("intStream所有元素的总数：" + intStream.count());
        System.out.println("intStream所有元素的平均值：" + intStream.average());
        System.out.println("intStream所有元素的平方是否都大于20：" + intStream.allMatch(ele -> ele * ele > 20));
        System.out.println("intStream是否包含任意元素的平方大于20：" + intStream.anyMatch(ele -> ele * ele > 20));
        // 将intStream映射成一个新Stream，新Stream的每个元素都是元Stream元素的2倍+1
        IntStream newIs = intStream.map(ele -> ele * 2 + 1);
        // 使用方法引用的方法来遍历集合元素
        newIs.forEach(System.out::println);
    }
}
