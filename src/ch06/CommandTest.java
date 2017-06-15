package ch06;

/**
 * 对数组的两种处理方式
 * Created by scn on 2017/6/15.
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] target = {3, -4, 6, 4};
        // 第一次处理数组，具体处理行为取决于PrintCommand
        processArray.process(target, new PrintCommand());
        System.out.println("-------------------");
        // 第二次处理数组，具体行为取决于AddCommand
        processArray.process(target, new AddCommand());
    }
}