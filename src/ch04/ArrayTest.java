package ch04;

public class ArrayTest {
	public static void main(String[] args) {
		// 定义一个int数组类型的变量
		int[] intArr;
		// 使用静态初始化，指定数组元素的初始值，不指定数组长度
		intArr = new int[]{5, 6, 7, 8};
		

		// 定义一个Object数组类型的变量
		Object[] objArr;
		// 使用静态初始化，初始化数组时数组元素的类型是定义数组时所指定的数组元素类型的子类
		objArr = new String[]{"Java", "李刚"};
		System.out.println(objArr[1]);
		objArr[0] = "Spring";

		// 数组的定义和初始化同时完成
		int[] a = {5, 6, 7, 8};


		// 动态初始化
		int[] prices = new int[5];
		// 输出数组每个元素的值
		for(int i = 0; i < prices.length; i++) {
			System.out.println(prices[i]);
		}

		String[] books = new String[4];
		// foreach循环
		for(String book : books) {
			System.out.println(book);
		}
	}
}