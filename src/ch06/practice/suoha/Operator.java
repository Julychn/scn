package ch06.practice.suoha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by scn on 2017/7/2.
 * 定义操作类，接受键盘输入，判断是否合法
 */
public class Operator {
    private BufferedReader bufferedReader = null;
    public Operator() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    public String getString(String info) {
        String str = null;
        System.out.print(info);
        try {
            str = this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public int getZero(String info, String err) {
        int temp = 0;
        boolean flag = true;
        while(flag) {
            String str = this.getString(info);
            if (str.equals("0")) {
                temp = Integer.valueOf(str);
                flag = false;
            } else {
                System.out.println(err);
            }
        }
        return temp;
    }
    public int getOneTwo(String info, String err) {
        int temp = 0;
        boolean flag = true;
        while(flag) {
            String str = this.getString(info);
            if (str.equals("1") || str.equals("2")) {
                temp = Integer.valueOf(str);
                flag = false;
            } else {
                System.out.println(err);
            }
        }
        return temp;
    }
}
