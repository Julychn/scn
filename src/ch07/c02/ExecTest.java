package ch07.c02;

import java.io.IOException;

/**
 * Created by scn on 2017/7/3.
 */
public class ExecTest {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        // 运行记事本程序
        rt.exec("/Applications/Notes.app");
    }
}
