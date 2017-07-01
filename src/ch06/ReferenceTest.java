package ch06;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by scn on 2017/7/1.
 */
public class ReferenceTest {
    /**
     * 弱引用测试
     */
    private static void WeakReferenceTest() {
        // 创建一个字符串对象
        String str = new String("疯狂java讲义");
        // 创建一个弱引用，让此弱引用引用到"疯狂Java讲义"字符串
        WeakReference wr = new WeakReference(str);
        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;
        // 取出弱引用所引用的对象
        System.out.println(wr.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }

    /**
     * 虚引用测试
     */
    private static void PhantomReferenceTest() {
        // 创建一个字符串对象
        String str = new String("疯狂Java讲义");
        // 创建一个引用队列
        ReferenceQueue rq = new ReferenceQueue();
        // 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
        PhantomReference pr = new PhantomReference(str, rq);
        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null
        System.out.println(pr.get());
        // 强制进行垃圾回收
        System.gc();
        System.runFinalization();
        // 垃圾回收之后，虚引用将被放入引用队列中
        // 取出引用队列中最先进入队列的引用与pr进行比较
        System.out.println(rq.poll() == pr);
    }
    public static void main(String[] args) throws Exception {
        WeakReferenceTest();
        System.out.println("-----------------");
        PhantomReferenceTest();
    }
}
