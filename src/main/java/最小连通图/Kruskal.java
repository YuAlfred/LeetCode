package 最小连通图;

import java.util.Arrays;

/**
 * @ Author     ：ty
 * @ Date       ：Created in 2019/4/11 1:00
 * @ Description：用最下生成树算法求最小连通图
 * @ Modified By：
 * @ Version:     1.0
 */
public class Kruskal {

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        int[][] graph = {{0, 0, 0, 5, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {0, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE}, {0, 0, 0, Integer.MAX_VALUE, 6, 7, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4, Integer.MAX_VALUE, 2},
                {3, Integer.MAX_VALUE, 6, 4, 0, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 0, 0, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 1,
                        0}

        };
        kruskal.minRoot(graph);

    }

    public void minRoot(int[][] graph) {
        //enabled存储边是否被启用,-1是已经自动连通，0是未连通，1是被连通
        int[][] enabled = getEnabled(graph);
        getSortedEdge(graph, enabled);
        printArray(graph);
        System.out.println("---------------");
        printArray(enabled);
    }

    public Edge[] getSortedEdge(int[][] graph, int[][] enabled) {
        int length = graph.length;
        Edge[] edges = new Edge[(length * length - length) / 2];
        //记录最小生成树的父节点情况以此判断其是否已经在一个团体
        int[] father = new int[length];
        //初始化，每个点的father都是其自己
        for (int i = 0; i < length; i++) {
            father[i] = i;
        }
        /**
         * 先把每条边都放入边数组中
         */
        int p = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                edges[p] = new Edge(i, j, graph[i][j]);
                p++;
            }
        }
        /**
         * 然后排序
         */
        Arrays.sort(edges);
        //从小到大拿出每一条边
        for (Edge edge : edges) {
            //此边是否两个顶点是否已在一个团体
            if (father(father, edge.start) == father(father, edge.end)) {
                //如果都在，继续下一个边
                continue;
            } else {
                //如果不都在，把这条边加入启用边，把两个顶点加入一个团体
                enabled[edge.start][edge.end] = 1;
                father[father(father, edge.end)] = father(father, edge.start);
            }
        }
        return edges;
    }

    public int[][] getEnabled(int[][] graph) {
        int length = graph.length;
        int[][] enabled = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (graph[i][j] == 0) {
                    enabled[i][j] = -1;
                } else {
                    enabled[i][j] = 0;
                }
            }
        }
        return enabled;
    }

    /**
     * 边对应的两个顶点是否均已经在最小连通图中
     */
    public boolean isInGraph(int[] visited, Edge edge) {
        return visited[edge.start] > 0 && visited[edge.end] > 0;
    }

    //打印数组
    public void printArray(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                if (j == Integer.MAX_VALUE) {
                    System.out.print("* ");
                } else {
                    System.out.print(j + " ");
                }

            }
            System.out.println();
        }
    }

    //找集体老大，并查集的一部分
    int father(int[] father, int x) {
        if (father[x] != x) {
            return father(father, father[x]);
        } else {
            return x;
        }
    }
}

/**
 * 边
 */
class Edge implements Comparable<Edge> {

    public int start;
    public int end;
    public int weight;


    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
