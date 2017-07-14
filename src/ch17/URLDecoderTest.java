package ch17;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by scn on 2017/7/14.
 * 使用URLDecoder和URLEncoder
 */
public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 解码成正常字符串
        String keyWord = URLDecoder.decode("%E6%88%91%E7%88%B1%E6%9C%B1%E4%B8%B9", "UTF8");
        System.out.println(keyWord);
        // 编码
        String urlStr = URLEncoder.encode("我爱朱丹", "UTF8");
        System.out.println(urlStr);
    }
}
