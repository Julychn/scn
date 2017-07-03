package ch07.c02;

/**
 * Created by scn on 2017/7/3.
 */
public class IdentityHashCodeTest {
    public static void main(String[] args) {
        // 下面程序中s1和s2是不同的对象
        String s1 = new String("hello");
        String s2 = new String("hello");
        // String重写了hashCode()方法，改为根据字符串序列计算hashcode值，所以他们的hashcode返回值相等
        System.out.println(s1.hashCode() + "-----" + s2.hashCode());
        // s1和s2是不同的字符串对象，identityHshCode()返回的值不同
        System.out.println(System.identityHashCode(s1) + "-----" + System.identityHashCode(s2));

        String s3 = "java";
        String s4 = "java";
        // s3和s4是相同的字符串对象，所以他们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3) + "-----" + System.identityHashCode(s4));
    }
}
