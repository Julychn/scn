package ch10;

/**
 * Created by scn on 2017/7/8.
 * 多线程程序中发生异常的情形
 */
public class ThreadExceptionTest implements Runnable {
    public void run() {
        firstMethod();
    }
    public void firstMethod() {
        secondMethod();
    }
    public void secondMethod() {
        int a = 5;
        int b = 0;
        int c = a / b;
    }
    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }
}
