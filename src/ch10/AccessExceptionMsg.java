package ch10;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by scn on 2017/7/7.
 * 访问异常信息
 */
public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
