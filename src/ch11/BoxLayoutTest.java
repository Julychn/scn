package ch11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scn on 2017/7/9.
 * BoxLayout布局测试
 */
public class BoxLayoutTest {
    private Frame frame = new Frame("测试窗口");
    public void init() {
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        // 下面按钮将会垂直排
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new BoxLayoutTest().init();
    }
}
