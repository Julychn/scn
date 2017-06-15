package ch05;

/**
 * 复用测试
 * Created by July on 2017/6/10.
 */
class Animal2 {
    private void beat() {
        System.out.println("心脏跳动。。。");
    }
    public void breath() {
        beat();
        System.out.println("呼吸中...");
    }
}

class Bird {
    // 将原来的父类组合到原来的子类，作为子类的一个组合部分
    private Animal2 a;
    public Bird(Animal2 a) {
        this.a = a;
    }
    // 重新定义一个自己的breath()方法
    public void breath() {
        // 直接复用Animal提供的breath()方法来实现Bird类的breath()方法
        a.breath();
    }
    public void fly() {
        System.out.println("飞翔中。。。");
    }
}

class Dog {
    // 同理
    private Animal2 a;
    public Dog(Animal2 a) {
        this.a = a;
    }
    public void breath() {
        a.breath();
    }
    public void run() {
        System.out.println("奔跑中。。。");
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        Animal2 a1 = new Animal2();
        Bird b = new Bird(a1);
        b.breath();
        b.fly();

        Animal2 a2 = new Animal2();
        Dog d = new Dog(a2);
        d.breath();
        d.run();
    }
}
