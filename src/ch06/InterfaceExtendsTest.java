package ch06;

/**
 * 接口多继承测试
 * Created by July on 2017/6/12.
 */
interface interfaceA {
    int PROP_A = 5;
    void testA();
}
interface interfaceB {
    int PROP_B = 6;
    void testB();
}
interface interfaceC extends interfaceA, interfaceB {
    int PROP_C = 7;
    void testC();
}

public class InterfaceExtendsTest {
    public static void main(String[] args) {
        System.out.println(interfaceA.PROP_A);
        System.out.println(interfaceB.PROP_B);
        System.out.println(interfaceC.PROP_C);
    }
}
