package ch08;

import java.util.ArrayDeque;

/**
 * Created by scn on 2017/7/6.
 * 把ArrayDeque当成队列来用
 */
public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        // 依次将三个元素加入队列
        queue.offer("疯狂Java讲义");
        queue.offer("轻量级Java EE企业应用实战");
        queue.offer("疯狂Android讲义");
        // 输出队列
        System.out.println(queue);
        // 访问队列的头部元素，但并不讲其poll出队列栈
        System.out.println(queue.peek());
        // 输出队列
        System.out.println(queue);
        // poll出第一个元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
