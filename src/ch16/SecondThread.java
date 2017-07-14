package ch16;

/**
 * Created by scn on 2017/7/14.
 * 实现Runnable接口创建线程类(共享线程类的实例变量)
 */
public class SecondThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                SecondThread st = new SecondThread();
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
            }
        }
    }
}
