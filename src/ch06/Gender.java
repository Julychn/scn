package ch06;

/**
 * Created by scn on 2017/7/1.
 */
public enum Gender implements GenderDesc {
    // 此处的枚举值必须调用对应的构造器来创建
    Male("男") {
        @Override
        public void info() {
            System.out.println("这个枚举值代表男性");
        }
    }, Female("女") {
        @Override
        public void info() {
            System.out.println("这个枚举值代表女性");
        }
    };
    private final String name;
    // 枚举类的构造器只能使用private修饰
    private Gender(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
//    public void info() {
//        System.out.println("这是一个用于定义性别的枚举类");
//    }
}
