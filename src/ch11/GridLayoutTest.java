package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * GridLayout布局测试，计算器可视化窗口
 */
public class GridLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");
        Panel panel = new Panel();
        panel.add(new TextField(40));
        frame.add(panel, BorderLayout.NORTH);
        Panel panel2 = new Panel();
        // 设置panel2使用GridLayout布局
        panel2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] name = {"0", "1", "2", "3", "4", "5",
                        "6", "7", "8", "9", "+", "-",
                        "*", "/", "."};
        // 向panel中添加15个组件
        for (int i = 0; i < name.length; i++) {
            panel2.add(new Button(name[i]));
        }
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);
    }
}
