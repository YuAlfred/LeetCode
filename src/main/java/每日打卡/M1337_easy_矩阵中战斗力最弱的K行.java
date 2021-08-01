package 每日打卡;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1337. 矩阵中战斗力最弱的 K 行
 * @date: 2021/8/1 12:29 上午
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1337_easy_矩阵中战斗力最弱的K行 {

    public int[] kWeakestRows(int[][] mat, int k) {

        Set<int[]> set = new HashSet<>();
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            // 二分找到军人数量
            int[] row = mat[i];
            int l = 0, r = n - 1;
            while (l <= r) {
                int middle = (l + r) / 2;
                if (row[middle] == 1) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
            // 军人数
            int num = r + 1;
            set.add(new int[]{i, num});
        }

        // 最小堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
            (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int[] row : set) {
            priorityQueue.add(row);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = priorityQueue.poll()[0];
        }

        return ans;
    }


}
