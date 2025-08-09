package 程序员面试经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 08.12. 八皇后
 * @date: 2020/10/12 6:44 下午
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_12_hard_八皇后 {

    public static void main(String[] args) {
        M8_12_hard_八皇后 m = new M8_12_hard_八皇后();
        m.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] q = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(q[i], '.');
        }
        List<List<String>> res = new LinkedList<>();
        find(q, 0, res);
        return res;
    }

    public void find(char[][] q, int i, List<List<String>> res) {
        if (i == q.length) {
            addRes(q, res);
            return;
        }
        for (int j = 0; j < q.length; j++) {
            if (check(q, i, j)) {
                q[i][j] = 'Q';
                find(q, i + 1, res);
                q[i][j] = '.';
            }
        }
    }

    public boolean check(char[][] q, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (q[k][j] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, v = j - 1; k >= 0 && v >= 0; k--, v--) {
            if (q[k][v] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, v = j + 1; k >= 0 && v < q.length; k--, v++) {
            if (q[k][v] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void addRes(char[][] q, List<List<String>> res) {
        List<String> temp = new LinkedList<>();
        for (char[] a : q) {
            temp.add(new String(a));
        }
        res.add(temp);
    }
}
















