package ch04;

import java.util.Arrays;

/**
 * Created by July on 2017/6/7.
 * Description: 将浮点数转换成人民币读法字符串
 */
public class Num2Rmb {
    // 用一个数组存储数字0~9对应的汉字
    private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    // 存储单位
    private String[] unitArr = {"十", "百", "千"};

    /**
     * 把一个浮点数分成整数部分和小树部分字符串
     * @param num 需要被分解的字符串
     * @return 分解出来的整数部分和小数部分，第一个数组元素是整数部分，第二个数组元素是小数部分
     */
    private String[] divide(double num) {
        // 将一个浮点数强制类型转换成long型，即可得到它的整数部分
        long zheng = (long)num;
        // 浮点数减去整数部分得到小数部分，小数部分乘以100后取整(round)得到2位小数
        long xiao = Math.round((num - zheng) * 100);
        // 下面用了2中方法把整数转换成字符串
        return new String[]{zheng + "", String.valueOf(xiao)};
    }

    /**
     * 把一个四位的数字字符串编程汉字字符串
     * @param numStr 需要被转换的四位数字字符串
     * @return 四位的数字字符串被转换成汉子字符串
     */
    private String toHanStr(String numStr) {
        String result = "";
        int numLen = numStr.length();
        // 依次遍历数字字符串的每一位数字
        for (int i = 0; i < numLen; i++) {
            // 把char型数字转换成int型数字，他们的ASCII码恰好差48
            // 把char型数字减去48得到int型数字
            int num = numStr.charAt(i) - 48;
            // 如果不是最后一位数字，而且数字不是0，则需要添加单位
            if(i != numLen - 1 && num != 0) {
                result += hanArr[num] + unitArr[numLen - 2 - i];
            }
            // 否则不需要添加单位
            else {
                result += hanArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Num2Rmb nr = new Num2Rmb();
        // 测试把一个浮点数分解成整数部分和小数部分
        System.out.println(Arrays.toString(nr.divide(236213498.1235)));
        // 测试把一个四位的数字字符串变成汉子字符串
        System.out.println(nr.toHanStr("5108"));
    }
}
