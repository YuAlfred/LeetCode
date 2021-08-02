package 每日打卡;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 743. 网络延迟时间
 * @date: 2021/8/2 12:32 上午
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M743_middle_网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        boolean[] visited = new boolean[n];
        int[] pointTimes = new int[n];
        Arrays.fill(pointTimes, Integer.MAX_VALUE);
        pointTimes[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            // 找到下一个更小节点
            int p = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (p == -1 || pointTimes[j] < pointTimes[p])) {
                    p = j;
                }
            }
            visited[p] = true;
            // 更新这个节点的所有子节点
            for (int j = 0; j < graph[p].length; j++) {
                if (graph[p][j] != Integer.MAX_VALUE) {
                    pointTimes[j] = Math.min(pointTimes[j], pointTimes[p] + graph[p][j]);
                }
            }
        }

        int ans = Arrays.stream(pointTimes).max().getAsInt();
        return ans==Integer.MAX_VALUE?-1:ans;

    }


}
