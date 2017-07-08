package ch11;

import java.awt.*;

/**
 * Created by scn on 2017/7/8.
 * GridBagLayout测试
 */
public class GridBagTest {
    private Frame frame = new Frame("测试窗口");
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button[] buttons = new Button[10];
    public void init() {
        frame.setLayout(gridBagLayout);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("按钮" + i);
        }
        // 所有组件都可以在横向、纵向上扩大
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        addButton(buttons[0]);
        addButton(buttons[1]);
        addButton(buttons[2]);
        // 该GridBagConstraints控制的GUI组件将会成为横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(buttons[3]);
        // 该GridBagConstraints控制的GUI组件将在横向上不会扩大
        gbc.weightx = 0;
        addButton(buttons[4]);
        // 该GridBagConstraints控制的GUI组件将横跨两个网格
        gbc.gridwidth = 2;
        addButton(buttons[5]);
        // 横跨一个网格
        gbc.gridwidth = 1;
        // 纵向跨两个网格
        gbc.gridheight = 2;
        // 横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(buttons[6]);
        // 横向跨一个网格，纵向两个
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        // 纵向扩大的权重是1
        gbc.weighty = 1;
        addButton(buttons[7]);
        // 纵向上不会扩大
        gbc.weighty = 0;
        // 横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // 纵向跨一个网格
        gbc.gridheight = 1;
        addButton(buttons[8]);
        addButton(buttons[9]);
        frame.pack();
        frame.setVisible(true);
    }

    private void addButton(Button button) {
        gridBagLayout.setConstraints(button, gbc);
        frame.add(button);
    }
    public static void main(String[] args) {
        new GridBagTest().init();
    }
}
