package lightProgram;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by scn on 2017/7/6.
 * 梭哈游戏
 */
public class ShowHand {
    // 定义该游戏最多支持多少个玩家
    private final int PLAY_NUM = 5;
    // 定义扑克牌的所有花色和数值
    private String[] types = {"方块", "草花", "红心", "黑桃"};
    private String[] values = {"2", "3", "4", "5", "6", "7",
                        "8", "9", "10", "J", "Q", "K", "A"};
    // cards是一局游戏中剩余的扑克牌，用一个LinkedList集合来存储
    private List<String> cards = new LinkedList<String>();
    // 定义所有的玩家
    private String[] players = new String[PLAY_NUM];
    // 所有玩家手上的扑克牌，使用列表数组保存
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 初始化扑克牌方法，给cards放入52张扑克牌
     * 并且使用Collections的shuffle方法将它们按随机顺序排列
     */
    public void initCards() {
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        // 随机排列
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家
     * 为每个玩家分派用户名
     * @param names 多个玩家用户名
     */
    public void initPlayers(String... names) {
        if (names.length > PLAY_NUM || names.length < 2) {
            // 校验玩家数量，此处使用异常机制更合理
            System.out.println("玩家数量不对");
            return ;
        } else {
            // 初始化玩家用户名
            for (int i = 0; i < names.length; i++) {
                players[i] = names[i];
            }
        }
    }

    /**
     * 初始化玩家手上的扑克牌，
     * 开始游戏时每个玩家手上的扑克牌为空，
     * 程序使用一个长度为0的LinkedList来表示
     */
    public void initPlayerCards() {
        for (int i = 0; i < players.length; i++) {
            // 此处由于玩家数量可能小于玩家数量上限，需要对玩家数组中为null的值进行判断
            if (players[i] != null && !players[i].equals("")) {
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    /**
     * 输出所有扑克牌，该方法没有实际作用，
     * 仅用作测试
     */
    public void showAllCards() {
        for (String card : cards) {
            System.out.print(card + " ");
        }
    }

    /**
     * 派扑克牌方法
     * @param first 最先派给哪个玩家
     */
    public void deliverCard(String first) {
        // 调用ArrayUtils工具类的search方法，查询出指定最先发牌玩家在数组中的索引
        int firstPos = ArrayUtils.search(players, first);
        // 依次给位于该指定玩家之后的每个玩家派扑克牌
        for (int i = firstPos; i < PLAY_NUM; i++) {
            // 判断该玩家是否存在
            if (players[i] != null) {
                // 将剩下的牌cards集合中的第一张赋给玩家手中
                playersCards[i].add(cards.get(0));
                // 从剩余的牌cards集合中删除这张已经赋给玩家的牌
                cards.remove(0);
            }
        }
        // 依次给位于该指定玩家之前的每个玩家派扑克牌
        for (int i = 0; i < firstPos; i++) {
            // 判断该玩家是否存在
            if (players[i] != null) {
                // 将剩下的牌cards集合中的第一张发给玩家
                playersCards[i].add(cards.get(0));
                // 从剩余的牌cards集合中删除这张已经赋给玩家的牌
                cards.remove(0);
            }
        }
    }

    /**
     * 输出玩家手上的扑克牌
     * 实现该方法时，应该控制每个玩家看不到别人的第一张底牌，
     * 但此处没有增加该功能
     */
    public void showPlayerCards() {
        for (int i = 0; i < PLAY_NUM; i++) {
            // 当该玩家存在时
            if (players[i] != null) {
                // 输出玩家名称
                System.out.print(players[i] + "：");
                // 遍历输出玩家手上的扑克牌
                for (String card : playersCards[i]) {
                    System.out.print("\t" + card);
                }
            }
            // 一个玩家输出结束后换行
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ShowHand sh = new ShowHand();
        // 初始化玩家，输入名称
        sh.initPlayers("孙悟空", "猪八戒", "沙僧", "唐僧");
        // 初始化扑克牌
        sh.initCards();
        // 初始化每个玩家手中的牌
        sh.initPlayerCards();
        // 测试所有扑克牌，没有实际作用
        sh.showAllCards();
        System.out.println("\n-------------");
        // 从"唐僧"开始派牌
        sh.deliverCard("孙悟空");
        sh.showPlayerCards();
        /*
        此处应该增加处理
        1.牌面最大的玩家下注
        2.其他玩家是否跟注
        3.游戏是否只剩一个玩家？如果是，则他胜利了
        4.如果已经是最后一张扑克牌，则需要比较剩下玩家的牌面大小
         */
        // 再次从"唐僧"开始发牌
        sh.deliverCard("唐僧");
        sh.showPlayerCards();
    }
}
