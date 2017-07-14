package ch17;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by scn on 2017/7/14.
 * InetAddress类测试
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        // 根据主机名来获取对应的InetAddress实例
        InetAddress ip1 = InetAddress.getByName("scniMac.local");
        System.out.println(ip1.getHostAddress());
        InetAddress ip2 = InetAddress.getByName("www.julychn.com");
        // 判断是否可达
        System.out.println("julychn.com是否可达：" + ip2.isReachable(2000));
        // 获取该InetAddress实例的IP字符串
        System.out.println(ip2.getHostAddress());
        // 根据原始IP地址来获取对应的InetAddress实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("本机是否可达：" + local.isReachable(5000));
        // 获取该InetAddress实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
    }
}
