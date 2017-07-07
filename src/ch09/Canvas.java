package ch09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scn on 2017/7/7.
 * 被限制的泛型通配符
 */
public class Canvas {
    /**
     * 使用受限制的泛型通配符
     * @param shapes 某种Shape形状的集合
     */
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas c = new Canvas();

        c.drawAll(circleList);

    }
}

abstract class Shape {
    public abstract void draw(Canvas c);
}
// 子类Circle
class Circle extends Shape {

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "上画一个圆形");
    }
}
class Rectangle extends Shape {

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "上画一个矩形");
    }
}
