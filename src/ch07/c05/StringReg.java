package ch07.c05;

import java.util.Arrays;

/**
 * Created by scn on 2017/7/4.
 */
public class StringReg {
    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions"
        };
        for (String msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈："));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}
