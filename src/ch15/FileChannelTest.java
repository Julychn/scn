package ch15;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by scn on 2017/7/13.
 */
public class FileChannelTest {
    public static void main(String[] args) {
        File file = new File("src/ch15/FileChannelTest.java");
        try (
                // 创建FileInputStream，以该文件输入流创建FileChannel
                FileChannel inChannel = new FileInputStream(file).getChannel();
                // 以文件输出流创建FileChannel，用以控制输出
                FileChannel outChannel = new FileOutputStream("src/ch15/out.txt").getChannel()
                ) {
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            // 使用UTF8的字符集来创建解码器
            Charset charset = Charset.forName("UTF8");
            // 直接将buffer里的数据全部输出
            outChannel.write(buffer);
            // 再次调用buffer的clear方法，复原limit、position的位置
            buffer.clear();
            // 创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
