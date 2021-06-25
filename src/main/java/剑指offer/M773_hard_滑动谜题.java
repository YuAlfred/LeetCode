package 剑指offer;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 773. 滑动谜题
 * @date: 2021/6/26 1:52 上午
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M773_hard_滑动谜题 {

    public static void main(String[] args) {
        M773_hard_滑动谜题 m = new M773_hard_滑动谜题();
        m.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
    }

    public int slidingPuzzle(int[][] board) {
        int[][] target = new int[][]{{1, 2, 3}, {4, 5, 0}};
        String targetKey = genKey(target);
        Map<String, Integer> steps = new HashMap<>();
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(board);
        steps.put(genKey(board), 0);
        if (genKey(board).equals(targetKey)) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[][] cur = queue.poll();
                String curKey = genKey(cur);
                List<int[][]> nexts = getList(cur);
                for (int[][] next : nexts) {
                    String nextKey = genKey(next);
                    if (steps.containsKey(nextKey)) {
                        continue;
                    }
                    int nextStep = steps.get(curKey) + 1;
                    if (nextKey.equals(targetKey)) {
                        return nextStep;
                    }
                    steps.put(nextKey, nextStep);
                    queue.add(next);
                }
            }
        }
        return -1;
    }


    public List<int[][]> getList(int[][] board) {
        List<int[][]> list = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (i > 0) {
                        int[][] copy = copy(board);
                        copy[i][j] = copy[i - 1][j];
                        copy[i - 1][j] = 0;
                        list.add(copy);
                    }
                    if (i < 1) {
                        int[][] copy = copy(board);
                        copy[i][j] = copy[i + 1][j];
                        copy[i + 1][j] = 0;
                        list.add(copy);
                    }
                    if (j > 0) {
                        int[][] copy = copy(board);
                        copy[i][j] = copy[i][j - 1];
                        copy[i][j - 1] = 0;
                        list.add(copy);
                    }
                    if (j < 2) {
                        int[][] copy = copy(board);
                        copy[i][j] = copy[i][j + 1];
                        copy[i][j + 1] = 0;
                        list.add(copy);
                    }
                    return list;
                }
            }
        }
        return null;
    }

    public String genKey(int[][] board) {
        return "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2];
    }

    public int[][] copy(int[][] board) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = board[i][j];
            }
        }
        return res;
    }

}
