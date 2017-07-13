package ch15;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Created by scn on 2017/7/13.
 */
public class CharSetTest {
    public static void main(String[] args) {
        // 获取Java支持的全部字符集
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String alias : map.keySet()) {
            System.out.println(alias + "-->" + map.get(alias));
        }
    }
}
