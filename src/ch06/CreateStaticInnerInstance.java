package ch06;

/**
 * 在外部类以外使用静态内部类
 * Created by scn on 2017/6/15.
 */
class StaticOut {
    // 定义一个静态内部类，不使用访问控制符，即同一个包中的其他类可访问该内部类
    static class StaticIn {
        public StaticIn() {
            System.out.println("静态内部类的构造器");
        }
    }
}

public class CreateStaticInnerInstance {
    public static void main(String[] args) {
        StaticOut.StaticIn in = new StaticOut.StaticIn();
        System.out.println("---------------");
        // 上面代码课改为如下代码：
        // 使用OuterClass.InnerClass的形式定义内部类变量
        StaticOut.StaticIn in1;
        // 通过new来调用内部类构造器创建静态内部类实例
        in = new StaticOut.StaticIn();
    }
}