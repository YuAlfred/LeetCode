package 每日打卡;

import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/1/21 13:57
 * @description : 1489. 找到最小生成树里的关键边和伪关键边
 * @modified By  :
 * <p>
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * <p>
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * <p>
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 * <p>
 * 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 * 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= min(200, n * (n - 1) / 2)
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti <= 1000
 * 所有 (fromi, toi) 数对都是互不相同的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1489_hard_找到最小生成树里的关键边和伪关键边 {

    public static void main(String[] args) {
        M1489_hard_找到最小生成树里的关键边和伪关键边 m = new M1489_hard_找到最小生成树里的关键边和伪关键边();
        m.findCriticalAndPseudoCriticalEdges(5, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}});
    }

    public UnionFind uf;
    public int minTotalWeight = Integer.MAX_VALUE;
    public List<Set<Integer>> minEdges;
    public List<Integer> path;

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Map<Integer, Integer> point2edges = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            point2edges.put(edges[i][0] * n + edges[i][1], i);
        }
        uf = new UnionFind(n);
        Arrays.sort(edges, Comparator.comparing(o -> o[2]));
        minEdges = new LinkedList<>();
        path = new LinkedList<>();
        dfs(0, 0, edges);
        List<Integer> mainEdges = new LinkedList<>();
        List<Integer> nuMainEdges = new LinkedList<>();
        Set<Integer> allEdges = new HashSet<>();
        //生成结果集
        for (Set<Integer> set : minEdges) {
            for (int i : set) {
                allEdges.add(i);
            }
        }
        //生成结果
        for (int i : allEdges) {
            boolean b = true;
            for (Set<Integer> set : minEdges) {
                if (!set.contains(i)) {
                    b = false;
                }
            }
            if (b) {
                mainEdges.add(point2edges.get(edges[i][0] * n + edges[i][1]));
            } else {
                nuMainEdges.add(point2edges.get(edges[i][0] * n + edges[i][1]));
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(mainEdges);
        res.add(nuMainEdges);
        return res;

    }

    public void dfs(int curTotalWeight, int i, int[][] edges) {
        //如果当前边权重和已经超过最小值了，剪枝
        if (curTotalWeight > minTotalWeight) {
            return;
        }
        //如果把所有边都遍历完了而且没有多的根
        if (i == edges.length) {
            if (uf.rootNum() == 1) {
                //如果当前权重和比最小的还小，更新结果集
                if (curTotalWeight < minTotalWeight) {
                    minTotalWeight = curTotalWeight;
                    minEdges = new LinkedList<>();
                    minEdges.add(new HashSet<>(path));
                } else if (curTotalWeight == minTotalWeight) {
                    //如果是相等，加上结果集
                    minEdges.add(new HashSet<>(path));
                }
            }
            return;
        }
        int[] edge = edges[i];
        //如果后面边的权重相等，考虑取或者不取，如果不等，直接取（可能取不到）
        //直接取看能不能取到
        //如果可以取
        if (uf.findRoot(edge[0]) != uf.findRoot(edge[1])) {
            //备份一下图
            int[] temp = uf.backupParent();
            curTotalWeight += edge[2];
            path.add(i);
            uf.union(edge[0], edge[1]);
            //继续递归
            dfs(curTotalWeight, i + 1, edges);
            //还原条件
            uf.parent = temp;
            path.remove(path.size() - 1);
            curTotalWeight -= edge[2];
        }
        if (uf.findRoot(edge[0]) == uf.findRoot(edge[1]) || (i != edges.length - 1 && edges[i][2] == edges[i + 1][2])) {
            //不取
            dfs(curTotalWeight, i + 1, edges);
        }

    }

    class UnionFind {
        public int[] parent;

        public UnionFind(int size) {
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int key) {
            while (parent[key] != key) {
                parent[key] = parent[parent[key]];
                key = parent[key];
            }
            return key;
        }

        public void union(int a, int b) {
            parent[findRoot(a)] = findRoot(b);
        }

        public int[] backupParent() {
            return Arrays.copyOf(parent, parent.length);
        }

        public int rootNum() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    res++;
                }
            }
            return res;
        }
    }
}
