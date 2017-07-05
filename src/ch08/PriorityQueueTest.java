package ch08;

import java.util.PriorityQueue;

/**
 * Created by scn on 2017/7/5.
 * PriorityQueue队列测试
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        // 下面代码依次向pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        // 输出pq队列，并不是按元素的加入顺序排列
        System.out.println(pq);
        // 访问队列中的第一个元素，其实就是队列中最小的数
        System.out.println(pq.poll());
    }
}
