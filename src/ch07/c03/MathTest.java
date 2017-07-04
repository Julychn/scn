package ch07.c03;

/**
 * Created by scn on 2017/7/4.
 * Math类测试
 */
public class MathTest {
    public static void main(String[] args) {
        // 下面是三角运算
        // 将弧度装换成角度
        System.out.println("Math.toDegrees(1.57): " + Math.toDegrees(1.57));
        // 将角度转换成弧度
        System.out.println("Math.toRadians(90): " + Math.toRadians(90));
        // 计算反余弦  反正弦asin(),反正切atan()同理
        System.out.println("Math.acos(0.5)：" + Math.acos(0.5));
        // 计算三角余弦  三角正弦  三角正切同理
        System.out.println("Math.cos(1.57)：" + Math.cos(1.57));
        // 将矩形坐标(x, y)转换成极坐标(r, thet)
        System.out.println("Math.atan2(0.1, 0.2): " + Math.atan2(0.1, 0.2));

        System.out.println("--------------------");


        // 下面是取整运算
        // 取整，返回小于目标数的最大整数
        System.out.println("Math.floor(-1.2): " + Math.floor(-1.2));
        // 取整，返回大于目标数的最小整数
        System.out.println("Math.ceil(1.2): " + Math.ceil(1.2));
        // 四舍五入取整
        System.out.println("Math.round(2.3)：" + Math.round(2.3));

        System.out.println("--------------------");

        // 下面是乘法、开方、指数运算
        // 计算平方根
        System.out.println("Math.sqrt(2.3): " + Math.sqrt(2.3));
        // 计算立方根
        System.out.println("Math.cbrt(8): " + Math.cbrt(8));
        // 计算乘方
        System.out.println("Math.pow(3, 2): " + Math.pow(3, 2));
        // 计算自然数对
        System.out.println("Math.log(12): " + Math.log(12));
        // 计算底数为10的对数
        System.out.println("Math.log10(9): " + Math.log10(9));

        System.out.println("--------------------");

        // 下面是符号相关的运算
        // 计算绝对值
        System.out.println("Math.abs(-4.5): " + Math.abs(-4.5));
        // 符号赋值，返回带有第二个符号的第一个浮点参数
        System.out.println("Math.copySign(1.2, -1.0): " + Math.copySign(1.2, -1.0));
        // 符号函数，若参数为0，返回0，若大于0，返回1.0，若小于0，返回-1.0
        System.out.println("Math.signum(2.3): " + Math.signum(2.3));

        System.out.println("--------------------");

        // 下面是大小相关的运算
        // 找出最大值，最小值同理
        System.out.println("Math.max(2.3, 4.5): " + Math.max(2.3, 4.5));
        // 返回第一个参数与第二个参数之间与第一个参数相邻的浮点数
        System.out.println("Math.nextAfter(1.2, 1.0): " + Math.nextAfter(1.2, 1.0));
        // 返回比目标数略大的浮点数
        System.out.println("Math.nextUp(1.2): " + Math.nextUp(1.2));
        // 返回一个伪随机数，该值大于等于0.0且小于1.0
        System.out.println("Math.random(): " + Math.random());
    }
}
