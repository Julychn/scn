package ch07.practice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scn on 2017/7/5.
 * 第三题，拆分字符串中的字母和数字，使用正则表达式
 */
public class P3 {
    public static void main(String[] args) {
        String str = "A1B2C3D4E5F6G7H8";
        Pattern patternW = Pattern.compile("[a-zA-Z]+");
        Pattern patternD = Pattern.compile("\\d+");
        Matcher matcherW = patternW.matcher(str);
        Matcher matcherD = patternD.matcher(str);
        String[] stringW = new String[8];
        int[] intD = new int[8];
        int i = 0;
        while (matcherW.find()) {
            stringW[i] = matcherW.group();
            i++;
        }
        i = 0;
        while (matcherD.find()) {
            intD[i] = Integer.parseInt(matcherD.group());
            i++;
        }
        System.out.println(Arrays.toString(stringW));
        System.out.println(Arrays.toString(intD));
    }
}
