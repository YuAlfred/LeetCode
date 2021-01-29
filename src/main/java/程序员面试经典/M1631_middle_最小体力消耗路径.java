package 程序员面试经典;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1631. 最小体力消耗路径
 * @date: 2021/1/29 8:54 上午
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *  
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1631_middle_最小体力消耗路径 {

    public int minimumEffortPath(int[][] heights) {
        int col = heights[0].length;
        int n = heights.length * heights[0].length;
        int[] dir = new int[]{-1, 1, -col, col};
        List<int[]> lengths = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                int num = i * col + j;
                if (j < col - 1) {
                    lengths.add(new int[]{num, num + 1, Math.abs(heights[i][j] - heights[num / col][(num % col) + 1])});
                }
                if (i < heights.length - 1) {
                    lengths.add(new int[]{num, num + col, Math.abs(heights[i][j] - heights[num / col + 1][num % col])});
                }
            }

        }
        Collections.sort(lengths, Comparator.comparing(o -> o[2]));
        int res = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] length : lengths) {
            if (uf.find(0) == uf.find(n - 1)) {
                break;
            }
            if (uf.union(length[0], length[1])) {
                res = length[2];
            }
        }
        return res;

    }

    class UnionFind {

        int[] parent;
        int size;

        public UnionFind(int size) {
            parent = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int key) {
            while (parent[key] != key) {
                parent[key] = parent[parent[key]];
                key = parent[key];
            }
            return key;
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                size--;
                parent[rootA] = rootB;
                return true;
            }
            return false;
        }

    }

}
