package ch06;

/**
 * 电脑类，需要组合一个输出设备
 * Created by July on 2017/6/13.
 */
public class Computer {
    private Output out;
    public Computer(Output out) {
        this.out = out;
    }
    // 定义一个模拟获取字符串输入的方法
    public void keyIn(String msg) {
        out.getData(msg);
    }
    // 定义一个模拟打印方法
    public void print() {
        out.out();
    }
}
