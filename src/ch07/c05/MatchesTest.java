package ch07.c05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scn on 2017/7/4.
 */
public class MatchesTest {
    public static void main(String[] args) {
        String[] mails = {
                        "kongyeekuu@163.com",
                        "kongyeeku@gmail.com",
                        "ligang@crazyit.org",
                        "wawa@abc.xx"
                };
        String mailRegEx = "\\w{3,20}@\\w+.(com|org|cn|net|gov)";
        Pattern pattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = pattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮箱地址";
            System.out.println(result);
        }

        // String类中也提供了matches()方法，该方法返回该字符串是否匹配指定的正则表达式
        boolean b = "kongyeeku@163.com".matches("\\w{3,20}@\\w+.(com|net|cm|gov|org)");
        System.out.println(b);
    }
}
