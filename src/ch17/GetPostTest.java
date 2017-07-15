package ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by scn on 2017/7/15.
 */
public class GetPostTest {
    /**
     * 向指定url发送GET方法的请求
     * @param url   发送请求的URL
     * @param param 请求参数，格式满足name1=value1&name2=value2的形式
     * @return      URL代表远程资源的响应
     */
    public static String sendGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1； SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有的响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "-->" + map.get(key));
            }
            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), "utf-8")
                    )
                    ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result.append("\n").append(line);
                }
            }
        } catch (IOException e) {
            System.out.println("发哦少年宫Get请求出现异常！" + e);
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 向指定URL发送POST方式的请求
     * @param url   发送请求的URL
     * @param param 请求参数，格式应满足name1=value1&name2=value2的格式
     * @return      URL代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 发送post请求必须发送如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (
                    // 获取URLConnection对象对象的输出流
                    PrintWriter out = new PrintWriter(conn.getOutputStream())
                    ) {
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))
                    ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result.append("\n").append(line);
                }
            }
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // 发送GET请求
        String s = GetPostTest.sendGet("http://www.julychn.com/user.php", null);
        System.out.println(s);
        // 发送post请求
    }
}
