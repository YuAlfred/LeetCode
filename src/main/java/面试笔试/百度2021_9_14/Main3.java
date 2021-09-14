package 面试笔试.百度2021_9_14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/14 7:47 下午
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int s = in.nextInt() - 1;
        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            graph[u][v] = Math.min(graph[u][v], in.nextInt());
        }
        for (int i = 0; i < k; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int q = in.nextInt();
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = in.nextInt() - 1;
        }
        in.close();
        int cost = 0;
        int start = s;
        for (int i : qs) {
            int roadCost = countCost(graph, start, i);
            cost += roadCost;
            start = i;
            // 如果为奇数
            if ((cost & 1) == 1) {
                cost += a;
            } else {
                // 偶数
                cost += b;
            }
        }
        // 最后回到村里
        cost += countCost(graph, start, s);
        System.out.println(cost);
    }

    public static int countCost(int[][] graph, int start, int end) {
        if (start == end) {
            return 0;
        }
        int n = graph.length;
        int[] costs = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(costs, Integer.MAX_VALUE / 2);
        costs[start] = 0;
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            costs[i] = Math.min(costs[i], costs[start] + graph[start][i]);
        }
        while (true) {
            // 先找最小的
            int cur = 0;
            int cost = Integer.MAX_VALUE / 2;
            for (int i = 0; i < costs.length; i++) {
                if (!visited[i] && costs[i] < cost) {
                    cost = costs[i];
                    cur = i;
                }
            }
            if (cur == end) {
                return costs[cur];
            }
            visited[cur] = true;
            for (int i = 0; i < n; i++) {
                costs[i] = Math.min(costs[i], costs[cur] + graph[cur][i]);
            }
        }

    }

}
