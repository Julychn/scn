package ch05;

/**
 * 强制类型转换测试
 * Created by July on 2017/6/9.
 */
public class ConversionTest {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long)d;
        System.out.println(l);
        int in = 5;
        // 试图把一个数值类型的变量转换成boolean类型，下面代码编译出错
        // boolean b = (boolean)in;
        Object obj = "hello";
        // obj变量的编译时类型为Object，与String存在继承关系，可以强制类型转换
        // 而且obj变量的实际类型是String，所以运行时也可通过
        String objStr = (String)obj;
        System.out.println(objStr);
        // 定义一个objPri变量，编译时类型为Object，实际类型为Integer
        Object objPri = new Integer(5);
        // objPri变量的编译时类型为Object，运行时类型为Integer
        // Object与Integer存在继承关系，可以强制转换，而objPri变量的实际类型是Integer
        // 所以下面的代码运行时引发ClassCastException异常
        // String str = (String)objPri;

        // 使用instanceof关键字判断能否进行强制转换
        if (objPri instanceof String) {
            String str = (String)objPri;
        } else {
            System.out.println("不能进行强制类型转换!");
        }

    }
}
