package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 802. 找到最终的安全状态
 * @date: 2021/8/5 12:22 上午
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * <p>
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * <p>
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * <p>
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * 示例 2：
 * <p>
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 *  
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 104] 内。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M802_middle_找到最终的安全状态 {


    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            isSafe(color, graph, i);
        }

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 2) {
                ans.add(i);
            }
        }
        return ans;

    }


    public boolean isSafe(int[] color, int[][] graph, int node) {
        if (color[node] == 2) {
            return true;
        } else if (color[node] == 1) {
            return false;
        } else {
            int[] nextNodes = graph[node];
            boolean isSafe = true;
            color[node] = 1;
            for (int nextNode : nextNodes) {
                isSafe &= isSafe(color, graph, node);
            }
            color[node] = isSafe ? 2 : 1;
            return isSafe;
        }
    }


}
