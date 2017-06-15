package ch06;

/**
 * 区分外部类成员变量、内部类成员变量与内部类里方法的具备变量同名
 * Created by scn on 2017/6/15.
 */
public class DiscernVariable {
    private String prop = "外部类的实例变量";
    private class InClass {
        private String prop = "内部类的实例变量";
        public void info() {
            String prop = "局部变量";
            // 通过外部类类名.this.varName访问外部类实例变量
            System.out.println("外部类的实例变量值：" + DiscernVariable.this.prop);
            // 通过this.varName访问内部类的实例变量
            System.out.println("内部类的实例变量值：" + this.prop);
            // 直接访问局部变量
            System.out.println("局部变量的值：" + prop);
        }
    }
    public void test() {
        InClass in = new InClass();
        in.info();
    }
    public static void main(String[] args) {
        new DiscernVariable().test();
    }
}
