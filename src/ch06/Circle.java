package ch06;

/**
 * 圆类
 * Created by July on 2017/6/12.
 */
public class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.setRadius(radius);
    }
    public void setRadius(double radius) {
        if (radius < 0) {
            System.out.println("请输入非零数");
            return;
        }
        this.radius = radius;
    }
    // 重写Shape的计算周长的方法
    public double callPerimeter() {
        return radius * 2 * Math.PI;
    }
    // 重写Shape的返回形状方法
    public String getType() {
        return "圆形";
    }

    public static void main(String[] args) {
        Shape s1 = new Triangle("blue", 3, 4, 5);
        Shape s2 = new Circle("black", 5);
        System.out.println("------------------------");
        System.out.println(s1.callPerimeter());
        System.out.println(s1.getType());
        System.out.println("------------------------");
        System.out.println(s2.callPerimeter());
        System.out.println(s2.getType());
    }
}
