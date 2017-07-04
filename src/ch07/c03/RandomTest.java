package ch07.c03;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by scn on 2017/7/4.
 * Random类测试
 */
public class RandomTest {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean()：" + rand.nextBoolean());
        byte[] buffer = new byte[16];
        rand.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        // 生成0.0~1.0之间的伪随机double数
        System.out.println("ran.nextDouble(): " + rand.nextDouble());
        // 生成一个处于int整数取值范围的伪随机整数
        System.out.println(rand.nextInt());
        // 成成0~26的伪随机整数
        System.out.println(rand.nextInt(26));

        // 避免伪随机，使用当前时间作为Random对象的种子
        Random random = new Random(System.currentTimeMillis());

        // ThreadLocalRandom与Random基本类似
        ThreadLocalRandom random1 = ThreadLocalRandom.current();
        // 生成一个4~20之间的伪随机整数
        System.out.println(random1.nextInt(4, 20));
        // 生成一个2.0~5.0之间的伪随机浮点数
        System.out.println(random1.nextDouble(2.0, 5.0));

    }
}
