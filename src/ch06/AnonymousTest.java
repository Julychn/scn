package ch06;

/**
 * 匿名内部类测试
 * Created by scn on 2017/6/15.
 */
interface Product1 {
    public double getPrice();
    public String getName();
}

public class AnonymousTest {
    public void test(Product1 p) {
        System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());
    }
    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        // 调用test()方法时，需要传入一个Product参数
        // 此处传入其匿名实现类的实例
        ta.test(new Product1() {
            public String getName() {
                return "疯狂Java讲义";
            }
            public double getPrice() {
                return 108.0;
            }
        });
    }
}
