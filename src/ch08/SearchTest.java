package ch08;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by scn on 2017/7/6.
 * Collections工具类的查找、替换操作
 */
public class SearchTest {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        // 输出最大值
        System.out.println(Collections.max(nums));
        // 将nums中的0用1来代替
        Collections.replaceAll(nums, 0, 1);
        System.out.println(nums);
        // 返回-5在集合中出现的次数
        System.out.println(Collections.frequency(nums, -5));
        // 排序
        Collections.sort(nums);
        System.out.println(nums);
        // 排序后使用二分法查询3的索引
        System.out.println(Collections.binarySearch(nums, 3));
    }
}
