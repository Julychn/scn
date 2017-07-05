package ch07.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by scn on 2017/7/5.
 * 接受用户输入的整数保存到数组中求平均值
 */
public class ArraysAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[10];
        System.out.println("请输入10个整数,使用空格或回车隔开：");
        for (int i = 0; i < ints.length; i++) {
            if (scanner.hasNextInt()) {
                ints[i] = scanner.nextInt();
            }
        }
        System.out.println("您输入的10个整数为：" + Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println("最小值为：" + ints[0]);
        System.out.println("最大值为：" + ints[ints.length - 1]);
        System.out.println("平均值为：" + getIntsAvg(ints));
    }

    public static double getIntsAvg(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum * 1.0 / ints.length;
    }
}
