package ch06;

/**
 * 单例类测试
 * Created by July on 2017/6/12.
 */
class Singleton {
    // 使用一个类变量来缓存曾经创建的实例
    private static Singleton instance;
    // 对构造器使用private修饰，隐藏该构造器
    private Singleton() {}
    // 提供一个静态方法，用于返回Singleton实例
    // 该方法可以加入自定义控制，保证只产生一个Singleton对象
    public static Singleton getInstance() {
        // 如果instance为null，表明还不曾创建Singleton对象，否则将不会重新创建
        if (instance == null) {
            // 创建一个Singleton对象，并将其缓存起来
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        // 创建Singleton对象不能通过构造器，只能通过getInstance方法来得到实例
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}