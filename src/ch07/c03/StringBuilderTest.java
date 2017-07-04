package ch07.c03;

/**
 * Created by scn on 2017/7/4.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // 追加字符串
        sb.append("java");
        // 插入
        sb.insert(0, "hello ");
        // 替换
        sb.replace(5, 6, ",");
        // 删除
        sb.delete(5, 6);
        // 反转
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        // 改变长度，只保留起前面部分
        sb.setLength(5);
        System.out.println(sb);
    }
}
