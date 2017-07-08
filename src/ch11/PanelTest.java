package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * Panel测试
 */
public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        // 创建一个Panel
        Panel panel = new Panel();
        // 向Panel中添加两个组件
        panel.add(new TextField(20));
        panel.add(new Button("单击我"));
        // 将Panel容器添加到Frame窗口中
        frame.add(panel);
        // 设置窗口的大小，位置
        frame.setBounds(30, 30, 350, 120);
        // 显示
        frame.setVisible(true);
    }
}
