package 每日打卡;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 787. K 站中转内最便宜的航班
 * @date: 2021/8/24 1:01 上午
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M787_middle_K站中转内最便宜的航班 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int[] newDp = new int[n];
            Arrays.fill(newDp, Integer.MAX_VALUE);
            for (int[] flight : flights) {
                if (dp[flight[0]] < Integer.MAX_VALUE) {
                    newDp[flight[1]] = Math.min(newDp[flight[1]], dp[flight[0]] + flight[1]);
                    if (flight[1] == dst) {
                        ans = Math.min(ans, newDp[flight[1]]);
                    }
                }
            }
            dp = newDp;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


}
