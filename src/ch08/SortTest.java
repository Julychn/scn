package ch08;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by scn on 2017/7/6.
 * 利用Collections工具类来操作List集合
 */
public class SortTest {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        // 次序反转
        Collections.reverse(nums);
        System.out.println(nums);
        // 自然排序
        Collections.sort(nums);
        System.out.println(nums);
        // 随机顺序排序
        Collections.shuffle(nums);
        System.out.println(nums);
    }
}
