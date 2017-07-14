package ch16;

/**
 * Created by scn on 2017/7/14.
 */
public class DrawThread extends Thread {
    private Account account;
    // 当前取钱线程所希望的取钱数
    private double drawAccount;
    public DrawThread(String name, Account account, double drawAccount) {
        super(name);
        this.account = account;
        this.drawAccount = drawAccount;
    }
    // 当多个线程修改同一个共享数据时，将涉及数据安全问题

    @Override
    public void run() {
        account.draw(drawAccount);
    }

    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
    }
}
