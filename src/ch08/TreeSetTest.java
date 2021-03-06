package ch08;

import java.util.TreeSet;

/**
 * Created by scn on 2017/7/5.
 * TreeSet集合类测试
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        // 输出集合元素，已处于排序状态
        System.out.println(nums);
        // 输出集合里的第一个元素
        System.out.println(nums.first());
        // 输出集合里的最后一个元素
        System.out.println(nums.last());
        // 返回小于4的子集，不包含4
        System.out.println(nums.headSet(4));
        // 返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println(nums.tailSet(5));
        // 返回大于等于-3，小于4的子集
        System.out.println(nums.subSet(-3, 4));
    }
}
