package ch17;

import java.util.Scanner;

/**
 * Created by scn on 2017/7/16.
 * 输出杨辉三角形
 */
public class test1 {
    public static void main(String[] args) {
        // 杨辉三角形的层数
        int m = 0;
        int[][] a;
        Scanner sc = new Scanner(System.in);
        while ((m = sc.nextInt()) != 0) {
            a = new int[m][m];
            for (int i = 0; i < m; i++) {
                a[i][0] = 1;
                a[i][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= i; j++) {
                    if (a[i][j] == 0) {
                        a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                        System.out.print(" " + a[i][j]);
                    } else {
                        if (j == 0) {
                            System.out.print("1");
                        } else {
                            System.out.print(" 1");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
