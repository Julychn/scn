package ch04;

public class ArrayInRam {
	public static void main(String[] args) {
		// 定义a，b数组
		int[] a = {5, 7, 20};
		int[] b = new int[4];
		// 输出b的长度
		System.out.println("b数组的长度为：" + b.length);
		//循环输出a数组的元素
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		// 循环输出b数组的元素
		for(int bb : b) {
			System.out.println(bb);
		}

		// 让b引用指向a的数组
		b = a;
		// 再次输出b的长度
		System.out.println("b的长度为：" + b.length);
	}
}