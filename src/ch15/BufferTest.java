package ch15;

import java.nio.CharBuffer;

/**
 * Created by scn on 2017/7/13.
 */
public class BufferTest {
    public static void main(String[] args) {
        // 创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity：" + buff.capacity());
        System.out.println("limit: " + buff.limit());
        System.out.println("position: " + buff.position());
        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素后，position = " + buff.position());
        // 调用flip方法
        buff.flip();
        System.out.println("执行flip后，limit = " + buff.limit());
        System.out.println("position = " + buff.position());
        // 取出第一个元素
        System.out.println("第一个元素: " + buff.get());
        System.out.println("取出第一个元素后，position为：" + buff.position());
        // 调用clear()方法
        buff.clear();
        System.out.println("调用clear后，limit = " + buff.limit());
        System.out.println("调用clear后，position = " + buff.position());
        System.out.println("执行clear后，缓冲区内容并没有被清除：" + "第三个元素为: " + buff.get(2));
        System.out.println("执行绝对读取后，position = " + buff.position());
    }
}
