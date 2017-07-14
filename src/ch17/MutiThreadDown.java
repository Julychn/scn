package ch17;

import java.io.IOException;

/**
 * Created by scn on 2017/7/14.
 */
public class MutiThreadDown {
    public static void main(String[] args) throws IOException {
        // 初始化DownUtil对象
        final DownUtil downUtil = new DownUtil("http://sw.bos.baidu.com/sw-search-sp/software/865661a83819e/PotPlayerSetup_1.7.2710.0.exe"
                , "PotPlayerSetup64.exe", 4);
        // 开始下载
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                // 每隔0.1秒查询一次任务的完成进度
                System.out.println("已完成：" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
