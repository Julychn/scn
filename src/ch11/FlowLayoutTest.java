package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * FlowLayout布局测试
 */
public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        // 设置Frame容器使用FlowLayout布局
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        // 添加10个按钮
        for (int i = 0; i < 10; i++) {
            frame.add(new Button("按钮" + i));
        }
        // 设置窗口为最佳大小
        frame.pack();
        // 显示
        frame.setVisible(true);
    }
}
