package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by July on 2017/6/8.
 * 使用循环输出等腰三角形
 */
public class ex2 {
    public static void main(String[] args){
        // 三角形的高
        int height = 1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入等腰三角形的高,输入0结束");
        try {
            while ((height = Integer.parseInt(bf.readLine())) != 0) {
                for (int i = 1; i <= height; i++) {
                    // 循环输出空格
                    for (int j = height - i; j >= 1; j--) {
                        System.out.print(" ");
                    }
                    // 循环输出"*"
                    for (int p = 1; p <= i * 2 - 1; p++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("不合法的输入！");
        }
    }
}
