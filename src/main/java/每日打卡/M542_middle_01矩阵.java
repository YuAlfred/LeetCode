package 每日打卡;

import 多线程.轮流打印.Main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 542. 01 矩阵
 * @date: 2021/3/23 3:28 下午
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 示例 2：
 * <p>
 * 输入：
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * 输出：
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M542_middle_01矩阵 {

    public int[][] updateMatrix(int[][] matrix) {

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                for (int l = 0; l < 4; l++) {
                    int nI = i + dir[l][0];
                    int nJ = j + dir[l][1];
                    if (nI >= 0 && nI < n && nJ >= 0 && nJ < m && !visited[nI][nJ]) {
                        ans[nI][nJ] = ans[i][j] + 1;
                        visited[nI][nJ] = true;
                        queue.add(new int[]{nI, nJ});
                    }
                }
            }
        }
        return ans;
    }

}
