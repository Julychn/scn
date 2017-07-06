package ch08;

import java.util.ArrayDeque;

/**
 * Created by scn on 2017/7/6.
 * 把ArrayDeque当成栈来使用
 */
public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        // 依次将三个元素push入栈
        stack.push("疯狂Java讲义");
        stack.push("轻量级Java EE企业应用实战");
        stack.push("疯狂Android讲义");
        System.out.println(stack);
        // 访问第一个元素，但并不将其pop出栈
        System.out.println(stack.peek());
        // pop出第一个元素
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
