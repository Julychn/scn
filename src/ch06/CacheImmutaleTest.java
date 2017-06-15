package ch06;

/**
 * 缓存实例的不可变类
 * Created by July on 2017/6/12.
 */
class CacheImmutale {
    private static int MAX_SIZE = 10;
    // 使用数组来缓存已有的实例
    private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];
    // 记录缓存实例在缓存中的位置，cache[pos-1]是最新缓存的实例
    private static int pos = 0;
    private final String name;

    private CacheImmutale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static CacheImmutale valueOf(String name) {
        // 遍历已缓存的对象
        for (int i = 0; i < MAX_SIZE; i++) {
            // 如果已有相同实例，则直接返回该缓存的实例
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        // 如果缓存池已满
        if (pos == MAX_SIZE) {
            // 把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始位置
            cache[0] = new CacheImmutale(name);
            // 把pos设置为1
            pos = 1;
        } else {
            // 把新创建的对象缓存起来，pos加1
            cache[pos++] = new CacheImmutale(name);
        }
        return cache[pos - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == CacheImmutale.class) {
            CacheImmutale ci = (CacheImmutale)obj;
            return name.equals(ci.getName());
        }
        return false;
    }
    public int hashCode() {
        return name.hashCode();
    }
}

public class CacheImmutaleTest {
    public static void main(String[] args) {
        CacheImmutale c1 = CacheImmutale.valueOf("hello");
        CacheImmutale c2 = CacheImmutale.valueOf("hello");
        // 下面代码将输出true
        System.out.println(c1 == c2);
    }
}
