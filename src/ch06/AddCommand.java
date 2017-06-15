package ch06;

/**
 * 处理方法
 * Created by scn on 2017/6/15.
 */
public class AddCommand implements Command {
    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int tmp : target) {
            sum += tmp;
        }
        System.out.println("数组元素的总和是：" + sum);
    }
}
