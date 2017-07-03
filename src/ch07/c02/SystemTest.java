package ch07.c02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by scn on 2017/7/3.
 */
public class SystemTest {
    public static void main(String[] args) throws IOException {
        // 获取系统所有的环境变量
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }
        System.out.println("--------------------");
        // 获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        // 获取所有的系统属性
        Properties properties = System.getProperties();
        // 将所有的系统属性保存到props.txt文件中
        properties.store(new FileOutputStream("props.txt"), "System Properties");
        // 输出特定的系统属性
        System.out.println(System.getProperty("os.name"));
    }
}
