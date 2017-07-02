package ch06.practice.suoha;

/**
 * Created by scn on 2017/7/2.
 * 项目需求：
 * 此类是一个梭哈游戏，这个类应该包含桌上剩下的牌的信息，
 * 并包含5个玩家的状态信息：
 * ----他们各自的位置、
 * ----游戏的状态（正在游戏或已放弃）、
 * ----手上已有的牌等信息。
 * 如果有可能，这个类还应该实现发牌方法：
 * ----这个方法需要控制从谁开始发牌，
 * ----不要发牌给放弃的人，
 * ----并修改桌上剩下的牌。
 *
 * 游戏分析：
 * 需要设计如下几个类：
 * 1、主面板类：MainTable
 *        能够循环生成主面板，每次有状态更新就刷新面板
 * 2、玩家类：Player
 *        此类应该包含如下的成员
 *            Field：名称、位置、游戏状态、牌信息
 *            方法()：选择()、
 *
 * 3、扑克牌类：Poker
 *        此类应该是一个枚举类，应该包含如下的成员：
 *            Field：牌（包含点数和花色）
 * 4、操作类：Operate
 *        此类是一个操作类，此类应该包含如下成员
 *            方法：发牌方法、判断输赢的方法、
 *
 * 设计思路：
 * MainTable类的设计思路应该是这样的：
 * 在面板出来之后，我们应该是使用手动
 * 输入数字0来控制发牌，发第一轮，底牌
 * 发第二轮第一张明牌，这个时候弹出选择面板
 * 从右边的选手开始，选1则跟进游戏，选2则不跟
 * 这个时候后台中应该有一个方法来设置选手们的flag参数
 * 如果flag=true则发牌给他，如果flag=fals，则不发牌
 * 这个会在sendPoker方法中有体现
 * 当游戏到达第五轮的时候，到了最终局，
 * 这一局中，我们要将所有个选手的牌全部都显示出来
 * 同时还要通过一个方法来判断输赢，
 * 不过由于判断的方法过于复杂，
 * 因此我们只输出结果，游戏结束，而不判断输赢。
 *
 * 项目总结：
 * --运行环境JDK1.6
 * 说明：目前，这个游戏可以完成以下请求:
 *      输出主面板，输出玩家的名称，底牌，牌面
 *      按0发牌，底牌和第一张明牌不需要玩家选择跟或不跟
 *      从第二张明牌开始，按0发牌后，会弹出选择按钮
 *      跟就按1，不跟就按2
 *      当发满第五轮的时候，游戏结束，根据牌面判断输赢。
 * 未完成的部分：
 *      1、避免重复发牌的方法
 *      2、判断输赢的方法
 */
public class MainTable {
    public MainTable() {
        init();
        while (true) {
            goGame();
        }
    }
    // 定义发牌者，他的牌就是剩下的牌
    private static Player admin = new Player();
    // 定义四个普通玩家
    private static Player up = new Player();
    private static Player left = new Player();
    private static Player down = new Player();
    private static Player right = new Player();
    // 定义一个数组，保存所有的牌
    private static String[] total = Poker.poker;
    // 记录发牌轮数
    private static int count = 0;
    private static String info = "等待游戏开始";

    /**
     * 绘制主面板
     */
    public static void getTable() {
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t                 " + up);
        System.out.println("\t\t\t\t\t\t  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.print(left);
        System.out.println("\t              "+admin.getInfo(info)+"\t\t\t\t"+right);
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("\t\t\t\t\t\t                 "+down);

        System.out.println("\t\t请输入数字0，开始游戏");
    }

    /**
     * 定义一个5个大小的数组用来保存用户的牌面，
     * 用52个大小的数组来保存发牌者的牌面，
     * 玩家没有牌，发牌这52张牌
     * 同时定义4个玩家的状态值是跟进（true）还是退出（false），
     * 采用boolean值，默认值为跟进（true）
     * 初始化姓名，这里的姓名可以自定义
     */
    public static void init() {
        admin.setName("admin");
        up.setName("Player1");
        left.setName("Player2");
        down.setName("Player3");
        right.setName("Player4");

        admin.setFlag(true);
        up.setFlag(true);
        left.setFlag(true);
        down.setFlag(true);
        right.setFlag(true);
        // 对用户的牌面数组进行初始化
        admin.setPok(total);
        up.setPok(new String[5]);
        left.setPok(new String[5]);
        down.setPok(new String[5]);
        right.setPok(new String[5]);
    }
    // 发牌方法
    String[] adminPoker = null;
    String[] upPoker = null;
    String[] leftPoker = null;
    String[] downPoker = null;
    String[] rightPoker = null;

    public void sendPoker() {
        adminPoker = admin.getPok();
        upPoker = up.getPok();
        leftPoker = left.getPok();
        downPoker = down.getPok();
        rightPoker = right.getPok();
        // 表明第一次发牌，则此牌为底牌，采用随机数发牌
        if (count == 0) {
            // 创建0-51的随机数，作为牌面数组的索引值，放到长度为4的数组中，分别对应4个玩家
            int[] t = new int[4];
            for (int i = 0; i < t.length; i++) {
                t[i] = (int)(Math.random()*52.0);
            }
            // 将牌面赋值给每位玩家
            upPoker[0] = adminPoker[t[0]];
            leftPoker[0] = adminPoker[t[1]];
            downPoker[0] = adminPoker[t[2]];
            rightPoker[0] = adminPoker[t[3]];
            // 发牌轮数加1
            count++;
        }
        // 若为第五轮，结束游戏
        if (count == 5) {
            info = "游戏结束";
        } else {
            if (up.getFlag()) {
                upPoker[count] = checkPoker((int)(Math.random()*52.0));
            }
            if (left.getFlag()) {
                leftPoker[count] = checkPoker((int)(Math.random()*52.0));
            }
            if (down.getFlag()) {
                downPoker[count] = checkPoker((int)(Math.random()*52.0));
            }
            if (right.getFlag()) {
                rightPoker[count] = checkPoker((int)(Math.random()*52.0));
            }
            count++;
        }

    }
    /**
     * 此方法用于判断随机牌是不是曾经发过，
     * 如果此牌发过，则将牌面重新随机一次
     * 由于实现的方法较为复杂，暂时就直接给出
     * */
    public String checkPoker(int t){
        return adminPoker[t];
    }

    /**
     * 定义游戏开始的主要方法，
     * 先绘制面板
     * 初始化
     * 发第一张底牌
     * 发第二张牌
     */
    public void goGame() {
        getTable();
        // 实例化操作类，可以接受键盘输入
        Operator operator = new Operator();
        int temp = operator.getZero("输入数字0开始发牌：", "输入错误，请重新输入");
        if (count == 5) {
            gameOver();
        }
        if (temp == 0 && count ==0) {
            info = "游戏正在进行中";
            // 开始发牌
            sendPoker();
        } else {
            checkPlayer();
            sendPoker();
        }
    }

    public void gameOver() {
        info = "游戏结束！";
        System.out.println("游戏结束！");
        System.exit(0);
    }

    public void checkPlayer() {
        Operator operator = new Operator();
        int t1 = operator.getOneTwo("Player1，跟进输入1，不跟进输入2", "输入错误，请重新输入：");
        if (t1 == 1) {
            up.setFlag(true);
        } else if (t1 == 2){
            up.setFlag(false);
        } else {
            System.out.println("输入错误，请重新输入。");
        }

        int t2 = operator.getOneTwo("Player2，跟进输入1，不跟进输入2", "输入错误，请重新输入：");
        if (t2 == 1) {
            left.setFlag(true);
        } else if (t2 == 2){
            left.setFlag(false);
        } else {
            System.out.println("输入错误，请重新输入。");
        }

        int t3 = operator.getOneTwo("Player3，跟进输入1，不跟进输入2", "输入错误，请重新输入：");
        if (t3 == 1) {
            left.setFlag(true);
        } else if (t3 == 2){
            left.setFlag(false);
        } else {
            System.out.println("输入错误，请重新输入。");
        }

        int t4 = operator.getOneTwo("Player4，跟进输入1，不跟进输入2", "输入错误，请重新输入：");
        if (t4 == 1) {
            left.setFlag(true);
        } else if (t4 == 2){
            left.setFlag(false);
        } else {
            System.out.println("输入错误，请重新输入。");
        }
    }

    public static void main(String[] args) {
        new MainTable();
    }
}
