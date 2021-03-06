package 每日打卡;

import lombok.val;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 803. 打砖块
 * @date: 2021/1/16 2:18 下午
 * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 * <p>
 * 一块砖直接连接到网格的顶部，或者
 * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 * <p>
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 * <p>
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
 * 输出：[2]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0]，
 * [1,1,1,0]]
 * 消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0]
 * [0,1,1,0]]
 * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
 * [[1,0,0,0],
 * [0,0,0,0]]
 * 因此，结果为 [2] 。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0],
 * [1,1,0,0]]
 * 消除 (1,1) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 * [1,0,0,0]]
 * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
 * [[1,0,0,0],
 * [1,0,0,0]]
 * 接下来消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 * [0,0,0,0]]
 * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
 * 因此，结果为 [0,0] 。
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[i][j] 为 0 或 1
 * 1 <= hits.length <= 4 * 104
 * hits[i].length == 2
 * 0 <= xi <= m - 1
 * 0 <= yi <= n - 1
 * 所有 (xi, yi) 互不相同
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M803_hard_打砖块 {

    //逻辑通了，有bug 懒得改了

    public static void main(String[] args) {
        val m = new M803_hard_打砖块();
        m.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}});
    }

    int[] parent;
    int[] contain;
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        //先让敲落的砖块消失
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] = 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int size = row * col + 1;
        parent = new int[size];
        contain = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            contain[i] = 1;
        }
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                union(j, size - 1);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int cur = i * col + j;
                for (int k = 0; k < 2; k++) {
                    int[] direction = directions[k];
                    int ni = i + direction[0];
                    int nj = j + direction[1];
                    if (ni >= row || ni < 0 || nj >= col || nj < 0) {
                        continue;
                    }
                    if (grid[ni][nj] == 1) {
                        union(cur, ni * col + nj);
                    }
                }
            }
        }
        //开始回填
        for (int i = hits.length - 1; i >= 0; i--) {
            int hitR = hits[i][0];
            int hitC = hits[i][1];
            int cur = hitR * col + hitC;
            grid[hitR][hitC] = 1;
            if (hitR == 0) {
                union(cur, size - 1);
            }
            int pastSize = contain[findRoot(size - 1)];
            for (int[] direction : directions) {
                int ni = hitR + direction[0];
                int nj = hitC + direction[1];
                int p = ni * col + nj;
                if (ni >= row || ni < 0 || nj >= col || nj < 0) {
                    continue;
                }
                if (grid[ni][nj] == 1) {
                    union(cur, p);
                }
            }
            if (findRoot(cur) != findRoot(size - 1)) {
                res[i] = 0;
            } else {
                res[i] = contain[findRoot(size - 1)] - pastSize - 1;
            }
        }
        return res;
    }

    public int findRoot(int key) {
        while (parent[key] != key) {
            parent[key] = parent[parent[key]];
            key = parent[key];
        }
        return key;
    }

    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
            contain[rootA] += contain[rootB];
        }
    }


}
