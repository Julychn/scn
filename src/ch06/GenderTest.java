package ch06;

/**
 * Created by scn on 2017/7/1.
 */
public class GenderTest {
    public static void main(String[] args) {
        // 通过Enum的valueof()方法来获取指定枚举类的枚举值
//        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        // 直接访问枚举值的name实例变量
//        System.out.println(g + "代表：" + g.getName());
        System.out.println(Gender.Female.getName());

    }
}
