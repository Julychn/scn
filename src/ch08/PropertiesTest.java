package ch08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by scn on 2017/7/6.
 * Properties类的用法测试
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        // 向props中添加属性
        props.setProperty("userName", "yeeku");
        props.setProperty("password", "123456");
        // 将props中的key-value对保存到a.ini文件中
        props.store(new FileOutputStream("src/ch08/a.ini"), "comment line");
        // 新建一个Properties对象
        Properties props2 = new Properties();
        // 添加属性
        props2.setProperty("gender", "male");
        // 将a.ini文件中的key-value对追加到props2中
        props2.load(new FileInputStream("src/ch08/a.ini"));
        System.out.println(props2);
    }
}
