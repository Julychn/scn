package ch06.practice;

/**
 * Created by scn on 2017/7/2.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("1.");
        Tractor tractor = new Tractor("拖拉机1", 100000);
        System.out.println(tractor.Start());
        System.out.println(tractor.Stop());

        System.out.println("2.");

    }
}
