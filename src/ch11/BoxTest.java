package ch11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scn on 2017/7/9.
 * Box容器测试
 */
public class BoxTest {
    private Frame frame = new Frame("测试");
    // 定义水平摆放组件的Box对象
    private Box boxH = Box.createHorizontalBox();
    // 垂直
    private Box boxV = Box.createVerticalBox();
    public void init() {
        boxH.add(new Button("水平按钮1"));
        boxH.add(new Button("水平按钮2"));
        boxV.add(new Button("垂直按钮1"));
        boxV.add(new Button("垂直按钮2"));
        frame.add(boxH, BorderLayout.NORTH);
        frame.add(boxV);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new BoxTest().init();
    }
}
