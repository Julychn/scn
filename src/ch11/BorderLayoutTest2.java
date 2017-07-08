package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * BorderLayout布局测试2
 */
public class BorderLayoutTest2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        frame.setLayout(new BorderLayout(30, 5));
        frame.add(new Button("南"), BorderLayout.SOUTH);
        frame.add(new Button("北"), BorderLayout.NORTH);
        // 创建一个panel对象
        Panel panel = new Panel();
        // 向Panel中添加两个组件
        panel.add(new TextField(20));
        panel.add(new Button("确定"));
        // 默认添加到中间
        frame.add(panel);
        frame.add(new Button("东"), BorderLayout.EAST);
        frame.add(new Button("西"), BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }
}
