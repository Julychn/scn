package ch05;

/**
 * 形参个数可变测试
 * Created by July on 2017/6/8.
 */
public class Varargs {
    // 定义了形参个数可变的方法
    public static void test(int i, String... books) {
        // books被当做数组处理
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        // 调用test方法
        test(3, "疯狂", "Java", "讲义");
    }
}
