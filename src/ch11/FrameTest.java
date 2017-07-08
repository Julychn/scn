package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * Frame测试
 */
public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        // 设置窗口的大小，位置
        frame.setBounds(30, 30, 250, 200);
        // 将窗口显示出来
        frame.setVisible(true);
    }
}
