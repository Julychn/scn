package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * ScrollPane带滚动条的容器测试
 */
public class ScrollPaneTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        // 创建一个ScrollPane容器，指定总是具有滚动条
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        // 向ScrollPane容器中添加两个组件
        sp.add(new TextField(20));
        sp.add(new Button("单击我"));
        // 将ScrollPane添加到Frame中
        frame.add(sp);
        // 设置窗口的大小、位置
        frame.setBounds(30, 30, 250, 120);
        // 显示出来
        frame.setVisible(true);
    }
}
