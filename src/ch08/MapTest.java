package ch08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scn on 2017/7/6.
 * Map的基本功能测试
 */
public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        // 成对放入多个key-value
        map.put("疯狂Java讲义", 109);
        map.put("疯狂iOS讲义", 10);
        map.put("疯狂Ajax讲义", 79);
        // 多次放入的value可以重复
        map.put("轻量级Java EE企业应用实战", 99);
        // 放入重复的key时，新的value会覆盖旧的
        // 如果新的value覆盖了原有的value，该方法返回被覆盖的value
        System.out.println(map.put("疯狂iOS讲义", 99));
        System.out.println(map);
        // 判断是否包含指定key、value
        System.out.println(map.containsKey("疯狂Java讲义"));
        System.out.println(map.containsValue(99));
        // 获取Map集合的所有key组成的集合，通过遍历key来实现遍历所有的key-value对
        for (Object key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        // 根据key来删除key-value对
        map.remove("疯狂Ajax讲义");
        System.out.println(map);
    }
}
