package ch04;

public class SwitchTest {
	public static void main(String[] args) {
		char score = 'C';
		// 执行switch分支语句
		switch(score)
		{
			case 'A':
				System.out.println("优秀");
				break;
			case 'B':
				System.out.println("良好");
				break;
			case 'C':
				System.out.println("中");
				break;
			default:
				System.out.println("成绩输入错误");
		}
	}
}