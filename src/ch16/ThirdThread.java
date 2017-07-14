package ch16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by scn on 2017/7/14.
 * 使用Callable和Future创建线程
 */
public class ThirdThread {
    public static void main(String[] args) {
        // 使用Lambda表达式创建Callable对象
        Callable<Integer> call = () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            // call方法可以有返回值
            return i;
        };
        // 使用FutureTask包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>(call);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程1").start();
                new Thread(task, "有返回值的线程2").start();
            }
        }
        try {
            // 获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
