package ch06;

/**
 * Created by scn on 2017/7/1.
 */
public enum Operation {
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double eval(double x, double y) {
            return x / y;
        }
    };

    // 为枚举类定义一个抽象方法，这个抽象方法由不同的枚举值提供不同的实现
    public abstract double eval(double x, double y);
    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 4));
    }
}
