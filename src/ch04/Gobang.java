package ch04;

import java.io.*;
import java.io.IOException;


/**
 * Created by July on 2017/6/7.
 * Description: 利用数组实现简单的五子棋
 */
public class Gobang {
    // 定义棋盘的大小
    private static int BOARD_SIZE = 15;
    // 定义一个二维数组来充当棋盘
    private String[][] board;

    /**
     * Description: 初始化棋盘，用一个二维数组来画出棋盘
     */
    public void initBoard() {
        // 初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        // 把每个元素赋为"╋●"，用于在控制台画出棋盘
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "╋";
            }
        }
    }

    /**
     * Description：在控制台输出棋盘
     */
    public void printBoard() {
        // 打印每个数组元素
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // 打印水平方向数组元素时不换行
                System.out.print(board[i][j]);
            }
            // 每打印完一行数组元素后换行
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();
        // 获取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        // br.readLine() 每当在键盘上输入一行内容后按回车，刚输入的内容将被br读取到
        while(!(inputStr = br.readLine()).equals("")) {
            // 将用户输入的字符串以逗号作为分隔符， 分隔成两个字符串
            String[] posStrArr = inputStr.split(",");
            // 将2个字符串转换成用户下棋的坐标
            int xPos = Integer.parseInt(posStrArr[0]);
            int yPos = Integer.parseInt(posStrArr[1]);
            // 把对应的数组元素赋为"●"
            gb.board[yPos - 1][xPos - 1] = "●";
            /*
            电脑下棋
             */
            gb.printBoard();
            System.out.println("请您输入您下棋的坐标，应以x,y的格式：");
        }
    }

}
