package ch10;

/**
 * Created by scn on 2017/7/7.
 * Java7的多异常捕获测试
 */
public class MultiExceptionTest {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println(c);
        } catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie) {
            System.out.println("程序发生了数组越界、数字格式异常、算术异常之一");
            // 捕获多异常时，异常变量默认有final修饰，不能修改
        } catch (Exception e) {
            System.out.println("未知异常");
            // 捕获一种类型的异常时，异常变量没有final修饰，下面代码正确
            e = new RuntimeException("test");
        }
    }
}
