package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * BorderLayout布局测试
 */
public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        // 设置frame使用BorderLayout布局
        frame.setLayout(new BorderLayout(30, 10));
        frame.add(new Button("南"), BorderLayout.SOUTH);
        frame.add(new Button("北"), BorderLayout.NORTH);
        // 默认添加到中间
        frame.add(new Button("中"));
        frame.add(new Button("东"), BorderLayout.EAST);
        frame.add(new Button("西"), BorderLayout.WEST);
        // 设置窗口为最佳大小
        frame.pack();
        // 显示窗口
        frame.setVisible(true);
    }
}
