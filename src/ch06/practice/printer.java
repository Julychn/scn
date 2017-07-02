package ch06.practice;

/**
 * Created by scn on 2017/7/2.
 * 接口测试
 */
interface InterfaceTest {
    String out();
}
public class printer {

    public static void main(String[] args) {
        System.out.println(new InterfaceTest() {
            @Override
            public String out() {
                return "使用匿名内部类实现接口实例";
            }
        }.out());

        InterfaceTest interfaceTest = () -> "使用Lambda表达式实现接口实例";
        System.out.println(interfaceTest.out());
    }
}
