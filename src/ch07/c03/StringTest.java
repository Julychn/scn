package ch07.c03;

/**
 * Created by scn on 2017/7/3.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("qwertyuiop");
        String s2 = new String("qwertyu");
        String s3 = new String("qwertyujop");
        System.out.println(s1.compareTo(s2));   // 返回长度差
        System.out.println(s1.compareTo(s3));   // 返回'i'-'j'的差
        System.out.println(s1.charAt(3));

        System.out.println("-----------------");

        String s4 = "qwerty";
        String s5 = "ty";
        System.out.println(s4.endsWith(s5));

        System.out.println("------------------");

        char[] c1 = {'I', ' ', 'L', 'o', 'v', 'e', ' ', 'J', 'a', 'v', 'e'};
        String str1 = new String("ejb");
        str1.getChars(0, 3, c1, 7);
        System.out.println(c1);

        System.out.println("------------------");

        String str2 = "www.google.com";
        String str3 = "gle";
        System.out.println(str2.indexOf(str3));
        System.out.println(str2.indexOf('o'));
        System.out.println(str2.indexOf('g', 5));
        System.out.println(str2.lastIndexOf('g'));
        System.out.println(str2.startsWith("www"));
        System.out.println(str2.startsWith("google", 4));
        System.out.println(str2.replace("google", "baidu"));
        System.out.println(str2.substring(4, 10));
        System.out.println(str2.toCharArray());
        System.out.println(str2.toUpperCase());

    }
}
