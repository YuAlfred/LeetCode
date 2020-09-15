package 每日打卡;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/15 9:37 上午
 * @description : 37. 解数独
 * @modified By  :
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M37_hard_解数独 {

    public Set<Character>[] row = new HashSet[9];
    public Set<Character>[] cul = new HashSet[9];
    public Set<Character>[][] cells = new HashSet[3][3];

    public void solveSudoku(char[][] board) {
        Set<Character> integers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            integers.add((char) (i + '1'));
        }
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>(integers);
            cul[i] = new HashSet<>(integers);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new HashSet<>(integers);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    row[i].remove(board[i][j]);
                    cul[j].remove(board[i][j]);
                    cells[i / 3][j / 3].remove(board[i][j]);
                }
            }
        }
        dfs(board,0);
    }

    public boolean dfs(char[][] board, int p) {
        if (p >= 81) {
            return true;
        }
        int i = p / 9;
        int j = p % 9;
        if (board[i][j] != '.') {
            return dfs(board, p + 1);
        } else {
            for (int k = 0; k < 9; k++) {
                char a = (char) (k + '1');
                if (row[i].contains(a) && cul[j].contains(a) && cells[i / 3][j / 3].contains(a)) {
                    row[i].remove(a);
                    cul[j].remove(a);
                    cells[i / 3][j / 3].remove(a);
                    board[i][j] = a;
                    if (dfs(board, p + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                    row[i].add(a);
                    cul[j].add(a);
                    cells[i / 3][j / 3].add(a);
                }
            }
        }
        return false;
    }
}
