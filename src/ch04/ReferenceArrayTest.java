package ch04;

/**
* Description: 人类
* @param age 年龄
* @param height 身高
*/
class Person {
	public int age;
	public double height;

	public void info() {
		System.out.println("我的年龄是：" + age + "，我的身高是：" + height);
	}
}

public class ReferenceArrayTest {
	public static void main(String[] args) {
		// 定义一个students数组变量，类型为Person[]
		Person[] students;
		// 动态初始化
		students = new Person[2];
		// 创建两个Person实例，并分别赋给变量zhang和变量lee
		Person zhang = new Person();
		zhang.age = 15;
		zhang.height = 158;
		Person lee = new Person();
		lee.age = 18;
		lee.height = 170;
		// 分别将zhang和lee的值赋给数组元素
		students[0] = zhang;
		students[1] = lee;
		// 输出同样的结果，引用的是同一个Person实例
		lee.info();
		students[1].info();
	}
}