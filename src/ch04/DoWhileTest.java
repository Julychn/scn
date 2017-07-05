package ch04;

public class DoWhileTest {
	public static void main(String[] args) {
		int count = 1;
		do {
			System.out.println(count);
			count++;
		} while(count < 10);
		System.out.println("循环结束");
	}
}