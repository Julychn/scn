package ch15;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by scn on 2017/7/12.
 * FileWriter测试
 */
public class FileWriterTest {
    public static void main(String[] args) {
        try (
                FileWriter fw = new FileWriter("src/ch15/poem.txt")
                ) {
            fw.write("锦瑟 - 李商隐\n");
            fw.write("锦瑟无端五十弦");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
