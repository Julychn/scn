package ch10;

/**
 * Created by scn on 2017/7/7.
 * 自定义异常类
 */
public class AuctionException extends Exception {
    // 无参构造器
    public AuctionException(){}
    // 带一个字符串的构造器
    public AuctionException(String msg) {
        super(msg);
    }
}
