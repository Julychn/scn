package ch16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by scn on 2017/7/14.
 * 使用线程池来执行指定的Runnable对象所代表的任务
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个具有固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 使用Lambda表达式来创建Runnable对象
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };
        // 向线程池中提交线程
        pool.submit(task);
        pool.submit(task);
        // 关闭线程池
        pool.shutdown();
    }
}
