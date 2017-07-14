package ch16;

/**
 * Created by scn on 2017/7/14.
 */
public class JoinThread extends Thread {
    // 提供一个有参数的构造器
    public JoinThread(String name) {
        super(name);
    }
    // 重写run()方法，定义线程执行提

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // 启动子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                // main线程调用了jt线程的join()方法，main线程必须等jt执行结束才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
