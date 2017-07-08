package ch11;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by scn on 2017/7/8.
 * CardLayout布局测试
 */
public class CardLayoutTest {
    Frame frame = new Frame("测试窗口");
    String names[] = {"第一张", "第二张", "第三张", "第四张", "第五张"};
    Panel panel = new Panel();
    public void init() {
        final CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        for (int i = 0; i < names.length; i++) {
            panel.add(names[i], new Button(names[i]));
        }
        Panel panel2 = new Panel();
        ActionListener listener = e -> {
            switch(e.getActionCommand()) {
                case "上一张":
                    cardLayout.previous(panel);
                    break;
                case "下一张":
                    cardLayout.next(panel);
                    break;
                case "第一张":
                    cardLayout.first(panel);
                    break;
                case "最后一张":
                    cardLayout.last(panel);
                    break;
                case "第三张":
                    cardLayout.show(panel, "第三张");
                    break;
            }
        };
        Button previous = new Button("上一张");
        previous.addActionListener(listener);
        Button next = new Button("下一张");
        next.addActionListener(listener);
        Button first = new Button("第一张");
        first.addActionListener(listener);
        Button last = new Button("最后一张");
        last.addActionListener(listener);
        Button third = new Button("第三张");
        third.addActionListener(listener);
        panel2.add(previous);
        panel2.add(next);
        panel2.add(first);
        panel2.add(last);
        panel2.add(third);
        frame.add(panel);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new CardLayoutTest().init();
    }
}
