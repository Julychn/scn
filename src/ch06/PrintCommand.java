package ch06;

/**
 * 处理行为
 * Created by scn on 2017/6/15.
 */
public class PrintCommand implements Command {

    @Override
    public void process(int[] target) {
        for (int tmp : target) {
            System.out.println("迭代输出目标数组的元素：" + tmp);
        }
    }
}
