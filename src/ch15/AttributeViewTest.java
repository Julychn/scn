package ch15;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

/**
 * Created by scn on 2017/7/13.
 */
public class AttributeViewTest {
    public static void main(String[] args) throws IOException {
        // 获取将要操作的文件
        Path testPath = Paths.get("src/ch15/AttributeViewTest.java");
        // 获取访问基本属性的BasicFileAttributeView
        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
        // 获取访问基本属性的BasicFileAttributes
        BasicFileAttributes basicAttribs = basicView.readAttributes();
        // 访问文件的基本属性
        System.out.println("创建时间：" + new Date(basicAttribs.creationTime().toMillis()));
        System.out.println("最后访问时间：" + new Date(basicAttribs.lastAccessTime().toMillis()));
        System.out.println("最后修改事件：" + new Date(basicAttribs.lastModifiedTime().toMillis()));
        System.out.println("文件大小：" + basicAttribs.size());
        // 获取访问文件主属性的FileOwnerAttributeView
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        // 获取该文件所属的用户
        System.out.println(ownerView.getOwner());
        // 获取系统中guest对应的用户
//        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        // 修改用户
//        ownerView.setOwner(user);
        // 获取访问自定义属性的FileOwnerAttributeView
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
        List<String> attrNames = userView.list();
        // 遍历所有的自定义属性
        for (String name : attrNames) {
            ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buf);
            buf.flip();
            String value = Charset.defaultCharset().decode(buf).toString();
            System.out.println(name + "-->" + value);
        }
        // 添加一个自定义属性
        userView.write("发行者", Charset.forName("UTF8").encode("疯狂Java联盟"));
    }
}
