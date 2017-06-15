package ch05;

/**
 * 初始化块测试
 * Created by July on 2017/6/10.
 */
class Root {
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root() {
        System.out.println("Root的无参数构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的普通初始化块");
    }
    public Mid() {
        System.out.println("Mid的无参构造器");
    }
    public Mid(String msg) {
        this();
        System.out.println("Mid的带参数构造器，参数值为：" + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的普通初始化块");
    }
    public Leaf() {
        // 通过super调用其父类中有一个字符串参数的构造器
        super("疯狂Java讲义");
        System.out.println("执行Leaf的构造器");
    }
}

public class Test {
    public static void main(String[] args) {
        // 第一次创建Leaf对象时，系统中还不存在Leaf类，需要先加载并初始化Leaf类，按顺序执行顶层父类的静态初始化块
        new Leaf();
        System.out.println("**************************");
        // Leaf类已经创建成功，第二次创建Leaf对象时，直接开始执行顶层父类的普通初始化块
        new Leaf();
    }
}
