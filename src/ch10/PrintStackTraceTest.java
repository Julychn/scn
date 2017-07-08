package ch10;

/**
 * Created by scn on 2017/7/8.
 * 异常跟踪栈
 */
public class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }
    public static void firstMethod() {
        secondMethod();
    }
    public static void secondMethod() {
        thirdMethod();
    }
    public static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}

class SelfException extends RuntimeException {
    SelfException() {}
    SelfException(String msg) {
        super(msg);
    }
}
