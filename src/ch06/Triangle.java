package ch06;

/**
 * 三角形类
 * Created by July on 2017/6/12.
 */
public class Triangle extends Shape {
    // 定义三角形的三边
    private double a;
    private double b;
    private double c;
    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.setSides(a, b, b);
    }
    public void setSides(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("三角形两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // 重写Shape类的计算周长的抽象方法
    public double callPerimeter() {
        return a + b + c;
    }
    // 重写Shape类的返回形状的抽象方法
    public String getType() {
        return "三角形";
    }
}
