package ch06;

/**
 * 使用Command接口定义一个方法，用来封装"处理行为"
 * Created by scn on 2017/6/15.
 */
public interface Command {
    // 接口里定义的process方法用于封装"处理行为"
    void process(int[] target);
}
