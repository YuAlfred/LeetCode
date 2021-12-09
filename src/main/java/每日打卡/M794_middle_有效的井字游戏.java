package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 794. 有效的井字游戏
 * @date: 2021/12/9 3:33 PM
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = ["XXX","   ","OOO"]
 * 输出：false
 * Example 4:
 * <p>
 * <p>
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M794_middle_有效的井字游戏 {

    public static void main(String[] args) {

    }

    public boolean validTicTacToe(String[] board) {
        // 先看个数能不能符合要求
        int xNums = 0, oNums = 0;
        for (String row : board) {
            for (int i = 0; i < 3; i++) {
                char c = row.charAt(i);
                switch (c) {
                    case 'X':
                        xNums++;
                        break;
                    case 'O':
                        oNums++;
                        break;
                }
            }
        }
        if (xNums < oNums || xNums > oNums + 1) {
            return false;
        }
        char[][] boardC = new char[3][3];
        for (int i = 0; i < 3; i++) {
            boardC[i] = board[i].toCharArray();
        }

        int has3 = count3(boardC);
        if (has3 == 0) {
            return true;
        }
        char c = ' ';
        if (xNums == oNums) {
            c = 'O';
        } else {
            c = 'X';
        }
        // 依次抽
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardC[i][j] == c) {
                    boardC[i][j] = ' ';
                    if (count3(boardC) == 0) {
                        return true;
                    }
                    boardC[i][j] = c;
                }
            }
        }
        return false;
    }

    public int count3(char[][] board) {
        // 数量能对上横纵斜有几个
        int has3 = 0;
        // 横
        for (int i = 0; i < 3; i++) {
            char[] s = board[i];
            if (s[0] != ' ' && s[0] == s[1] && s[1] == s[2]) {
                has3++;
            }
        }
        // 纵
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                has3++;
            }
        }
        // 斜
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            has3++;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            has3++;
        }
        return has3;
    }


}
