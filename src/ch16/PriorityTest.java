package ch16;

/**
 * Created by scn on 2017/7/14.
 */
public class PriorityTest extends Thread {
    public PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ", 其优先级是：" + getPriority() + ", 循环变量的值为：" + i);
        }
    }
    public static void main(String[] args) {
        // 改变主线程的优先级
        Thread.currentThread().setPriority(6);
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                PriorityTest low = new PriorityTest("低级");
                low.start();
                System.out.println("创建之初的优先级：" + low.getPriority());
                // 设置该线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                PriorityTest high = new PriorityTest("高级");
                high.start();
                System.out.println("创建之初的优先级：" + high.getPriority());
                // 设置优先级最高
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
