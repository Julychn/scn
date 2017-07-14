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
        // 使用account作为同步监视器，任何线程进入下面同步代码块前
        // 必须先获得对account账户的锁定，其他线程不发获得锁，也就无法修改
        // 这种做法符合："加锁->修改->释放锁"的逻辑
        synchronized (account) {
            // 账户余额大于取钱数目
            if (account.getBalance() >= drawAccount) {
                // 吐出钞票
                System.out.println(getName() + "取钱成功！吐出钞票：" + drawAccount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // 修改余额
                account.setBalance(account.getBalance() - drawAccount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "取钱失败！余额不足！");
            }
        }
        // 同步代码块结束，该线程释放同步锁
    }

    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
    }
}
