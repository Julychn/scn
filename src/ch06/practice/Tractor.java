package ch06.practice;

/**
 * Created by scn on 2017/7/2.
 * 拖拉机类，继承抽象车类
 */
public class Tractor extends Car {

    public Tractor(String name, double price) {
        super(name, price);
    }

    @Override
    public String Start() {
        return getName() + "启动";
    }

    @Override
    public String Stop() {
        return getName() + "熄火";
    }
}
