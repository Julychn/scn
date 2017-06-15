package ch05;

/**
 * 多态性 向上转型
 * 实例变量不存在多态
 * 调用方法时，子类若继承了该方法直接调用子类的方法，否则调用父类的方法
 * Created by July on 2017/6/9.
 */
class BaseClass {
    public int book = 6;
    public void base() {
        System.out.println("父类的普通方法");
    }
    public void test() {
        System.out.println("父类的被覆盖的方法");
    }
}

public class SubClass extends BaseClass {
    // 重新定义一个book实例变量隐藏父类的book实例变量
    public String book = "疯狂Java讲义";
    public void test() {
        System.out.println("子类的覆盖父类的方法");
    }
    public void sub() {
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {
        // 编译时类型和运行时类型一样，不存在多态
        BaseClass bc = new BaseClass();
        // 输出6
        System.out.println(bc.book);
        // 下面两次调用将执行BaseClass的方法
        bc.base();
        bc.test();

        // 下面编译时类型和运行时类型不一样，多态发生
        BaseClass ployBc = new SubClass();
        // 输出6，表明访问的是父类对象的实例变量
        System.out.println(ployBc.book);
        // 下面将执行从父类继承到的base()方法
        ployBc.base();
        // 下面将执行当前类的test()方法
        ployBc.test();
    }
}
