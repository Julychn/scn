package ch06;

/**
 * 工厂类，负责生成Output对象
 * Created by scn on 2017/6/13.
 */
public class OutputFactory {
    public Output getOutput() {
        // 若打印机发生变化，直接修改该处创建的对象即可让Computer类中所有使用打印机的位置发生更改
//        return new Printer();
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("轻量级Java EE企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }
}
