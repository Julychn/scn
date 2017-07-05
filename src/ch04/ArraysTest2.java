package ch04;

import java.util.Arrays;
import java.util.function.*;

public class ArraysTest2 {
	public static void main(String[] args) {
		int[] arr1 = new int[]{3, -4, 25, 16, 30, 18};
		// 对数组arr1进行并发排序
		Arrays.parallelSort(arr1);
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};
		Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
			// left代表数组中前一个索引处的元素，计算第一个元素时，left为1
			// right代表数组中当前索引处的元素
			public int applyAsInt(int left, int right) {
				return left * right;
			}
		});
		System.out.println(Arrays.toString(arr2));
	}
}