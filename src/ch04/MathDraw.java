package ch04;

import java.util.Scanner;

/**
 * Created by July on 2017/6/8.
 * 给定半径，打印出近似圆
 */
public class MathDraw {
    public static void main(String[] args) {
        System.out.print("请输入圆的半径(输入0结束)：");
        Scanner sc = new Scanner(System.in);
        int radius = 0;
        while ((radius = sc.nextInt()) > 0) {
            radius = Math.abs(radius);
            paint(radius);
            System.out.print("请输入圆的半径(输入0结束)：");
        }
    }

    /**
     * 打印圆的方法
     * @param r 圆的半径
     */
    public static void paint(int r) {
        // 假定圆心坐标在(r, r)处
        // x，y坐标的开始
        int x = 0;
        int y = 0;
        // 圆内每行空格数
        int c = 0;
        // 每行递减量，调节屏幕纵横比
        int z = 2;

        for (int i = 0; i <= r*2; i += z) {
            // 获取画"*"点的x坐标
            x = getX(r, y);
            // 1.先画y值上左边的点
            System.out.print(getSpace(x) + "*");
            // 2.再画圆内的空格
            c = (r - x) * 2;
            System.out.print(getSpace(c));
            // 3.最后画该y值上右边的*
            System.out.println("*");
            // 每画完一行，y值递增
            y += z;
        }
    }

    /**
     * 根据圆的半径和某点的纵坐标值来求改点的横坐标值
     * @param r 圆的半径
     * @param y 圆上某点的纵坐标y
     * @return 返回改点的横坐标x
     */
    private static int getX(int r, int y) {
        // 求直角三角形长边的长
        int h = y - r;
        // 求直角三角形短边的长
        double l = Math.sqrt(r*r-h*h);
        // 取x值，用round方法返回最接近的整数
        return (int)Math.round(r-l);
    }

    /**
     *
     * @param i 空格的个数
     * @return 返回i个空格的字符串
     */
    private static String getSpace(int i) {
        String s = "";
        for (int j = 0; j < i; j++) {
            s += " ";
        }
        return s;
    }
}
