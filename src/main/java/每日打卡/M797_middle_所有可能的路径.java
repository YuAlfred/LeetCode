package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: M797_middle_所有可能的路径
 * @date: 2021/8/25 11:55 下午
 */
public class M797_middle_所有可能的路径 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, ans, path, 0);
        return ans;
    }

    public void dfs(int[][] graph, List<List<Integer>> ans, LinkedList<Integer> path, int i) {
        path.add(i);
        if (i == graph.length - 1) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int j : graph[i]) {
            dfs(graph, ans, path, j);
        }
        path.removeLast();
    }


}
