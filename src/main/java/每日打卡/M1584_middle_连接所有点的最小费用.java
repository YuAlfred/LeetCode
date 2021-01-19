package 每日打卡;

import lombok.val;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/1/19 13:09
 * @description : 1584. 连接所有点的最小费用
 * @modified By  :
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1584_middle_连接所有点的最小费用 {

    public static void main(String[] args) {
        M1584_middle_连接所有点的最小费用 m = new M1584_middle_连接所有点的最小费用();
        m.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});

    }

    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        int size = (points.length) * (points.length - 1) / 2;
        UnionFind unionFind = new UnionFind(points.length);
        Edge[] edges = new Edge[size];
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges[count++] = new Edge(i, j,
                        Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o.length));
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (unionFind.findRoot(edge.from) != unionFind.findRoot(edge.to)) {
                unionFind.union(edge.from, edge.to);
                res += edge.length;
            }
        }
        return res;
    }

    class Edge {
        int from;
        int to;
        int length;

        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
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
    }
}




















