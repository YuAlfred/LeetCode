package 程序员面试经典;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/10 3:10 下午
 * @description : 面试题 04.01. 节点间通路
 * @modified By  :
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_1_middle_节点间通路 {


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        if (graph.length == 0 || graph[0].length == 0) {
            return false;
        }
        boolean[] visited = new boolean[n];
        List[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList();
        }
        for (int i = 0; i < graph.length; i++) {
            int s = graph[i][0];
            int d = graph[i][1];
            g[s].add(d);
        }
        return dfs(g, visited, start, target);

    }

    public boolean dfs(List[] g, boolean[] visited, int start, int end) {
        if (start == end) {
            return true;
        }
        visited[start] = true;
        boolean res = false;
        for (Integer i : (List<Integer>) g[start]) {
            if (!visited[i]) {
                res = dfs(g, visited, i, end) || res;
            }
        }
        return res;
    }


}














