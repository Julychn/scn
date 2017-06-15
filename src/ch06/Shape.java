package ch06;

/**
 * 抽象类
 * Created by July on 2017/6/12.
 */
public abstract class Shape {
    static {
        System.out.println("执行Shape的类初始化块");
    }
    {
        System.out.println("执行Shape的初始化块");
    }
    private String color;
    // 定义一个计算周长的抽象方法
    public abstract double callPerimeter();
    // 定义一个返回形状的抽象方法
    public abstract String getType();
    // 定义Shape的构造器，该构造器并不是用于创建Shape对象，而是被子类调用
    public Shape(){}
    public Shape(String color) {
        System.out.println("执行Shape的构造器");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
