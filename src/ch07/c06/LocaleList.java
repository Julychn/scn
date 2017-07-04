package ch07.c06;

import java.util.Locale;

/**
 * Created by scn on 2017/7/4.
 */
public class LocaleList {
    public static void main(String[] args) {
        // 返回Java所支持的全部国家和语言的数组
        Locale[] locales = Locale.getAvailableLocales();
        // 遍历数组的每个元素，依次获取所支持的国家的语言
        for (Locale locale : locales) {
            // 输出所支持的国家和语言
            System.out.println(locale.getDisplayCountry()
                    + "=" + locale.getCountry() + " "
                    + locale.getDisplayLanguage()
                    + "=" +locale.getLanguage()
            );
        }
    }
}
