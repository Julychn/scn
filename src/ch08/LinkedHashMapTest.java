package ch08;

import java.util.LinkedHashMap;

/**
 * Created by scn on 2017/7/6.
 * LinkedHashMap可以记住key-value对添加的顺序
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英语", 82);
        scores.put("数学", 76);
        // 调用forEach方法遍历
        scores.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
