package ch07.c05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scn on 2017/7/4.
 */
public class ReplaceTest {
    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions"
        };
        Pattern pattern = Pattern.compile("re\\w*");
        Matcher matcher = null;
        for (String msg : msgs) {
            if (matcher == null) {
                matcher = pattern.matcher(msg);
            } else {
                matcher.reset(msg);
            }
            System.out.println(matcher.replaceFirst("哈哈："));
        }
    }
}
