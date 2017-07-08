package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * 绝对定位测试
 */
public class NullLayoutTest {
    Frame frame = new Frame("测试窗口");
    Button b1 = new Button("第一个按钮");
    Button b2 = new Button("第二个按钮");
    public void init() {
        // 设置使用null布局管理器
        frame.setLayout(null);
        // 下面强制设置每个按钮的大小、位置
        b1.setBounds(20, 30, 90, 28);
        frame.add(b1);
        b2.setBounds(50, 45, 120, 35);
        frame.add(b2);
        frame.setBounds(50, 50, 200, 100);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new NullLayoutTest().init();
    }
}
