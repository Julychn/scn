package ch08;

import java.util.*;

/**
 * Created by scn on 2017/7/6.
 * 第八章课后习题
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println("-------------习题1-------------");
        Set set = new HashSet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入20个字符串，超过20个之外的字符串将不保存：");
        for (int i = 0; i < 20; i++) {
            if (scanner.hasNext()) {
                set.add(scanner.next());
            }
        }
        System.out.println("您输入的字符串集合为：" + set);

        System.out.println("\n-------------习题2-------------");
        List nums = new ArrayList();
        for (int i = 0; i < 10; i++) {
            nums.add(i * i);
        }
        System.out.println("nums集合为：" + nums);
        // 获取索引为5的元素
        System.out.println(nums.get(5));
        // 获取其中元素为49的索引
        System.out.println(nums.indexOf(25));
        // 删除索引为3的元素
        nums.remove(3);
        System.out.println(nums);

        System.out.println("\n-------------习题3-------------");
        String[] strings = {"a", "b", "a", "b", "c", "a", "b", "c", "b"};
        System.out.println(Arrays.toString(strings));
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                int temp = map.get(strings[i]);
                map.put(strings[i], ++temp);
            } else {
                map.put(strings[i], 1);
            }
        }
        System.out.println(map);
        // 通过获取map的所有key的集合来遍历map
        for (String key : map.keySet()) {
            System.out.println(key + "的出现次数为：" + map.get(key));
        }
    }
}
