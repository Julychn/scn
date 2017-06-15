package ch06;

/**
 * 处理数组的处理类，包含一个process方法，这个方法无法确定处理数组的处理行为，
 * 所以使用一个Command参数，负责对数组的处理行为
 * Created by scn on 2017/6/15.
 */
public class ProcessArray {
    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }
}
