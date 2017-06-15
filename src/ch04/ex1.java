package ch04;

/**
 * Created by July on 2017/6/8.
 * 99乘法表
 */
public class ex1 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j != 1) {
                    System.out.print(",");
                }
                System.out.print(i + "x" + j + "=" + i * j);
            }
            System.out.print("\n");
        }
    }
}
