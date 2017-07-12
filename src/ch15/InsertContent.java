package ch15;

import java.io.*;

/**
 * Created by scn on 2017/7/12.
 * 向指定文件、指定位置插入内容
 */
public class InsertContent {
    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                // 使用临时文件来保存插入点后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp)
                ) {
            raf.seek(pos);
            // -------下面代码将插入点后的内容读入临时文件中保存-------
            byte[] bbuf = new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 使用循环方式读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) > 0) {
                tmpOut.write(bbuf, 0, hasRead);
            }
            // ------下面代码用于插入内容------
            // 把文件指针重新定位到pos
            raf.seek(pos);
            System.out.println(raf.getFilePointer());
            // 追加需要插入的内容
            raf.write(insertContent.getBytes());
            System.out.println(raf.getFilePointer());
            // 追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        insert("src/ch15/test.txt", 20, "插入的内容\r\n");
    }
}
