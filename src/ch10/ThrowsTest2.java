package ch10;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by scn on 2017/7/7.
 */
public class ThrowsTest2 {
    public static void main(String[] args) throws IOException{
        /*
        因为test()方法声明抛出IOException异常
        所以调用test()的代码要么处于try...catch中
        要么处于另一个带throws声明抛出的方法中
         */
        test();
    }

    public static void test() throws IOException {
        /*
        因为FileInputStream的构造器声明抛出IOException异常
        所以调用FileInputStream的代码要么处于try...catch中
        要么处于另一个带throws声明抛出的方法中
         */
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
