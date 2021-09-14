package 面试笔试.百度2021_9_14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/14 7:47 下午
 */
public class Main3_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int s = in.nextInt() - 1;
        int[][] singleRoads = new int[m][3];
        int[][] doubleRoads = new int[k][3];
        for (int i = 0; i < m; i++) {
            singleRoads[i][0] = in.nextInt() - 1;
            singleRoads[i][1] = in.nextInt() - 1;
            singleRoads[i][2] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            doubleRoads[i][0] = in.nextInt() - 1;
            doubleRoads[i][1] = in.nextInt() - 1;
            doubleRoads[i][2] = in.nextInt();
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
            int roadCost = countCost(singleRoads, doubleRoads, start, i, n);
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
        cost += countCost(singleRoads, doubleRoads, start, s, n);
        System.out.println(cost);
    }

    public static int countCost(int[][] singleRoads, int[][] doubleRoads, int start, int end, int n) {
        if (start == end) {
            return 0;
        }
        int[] costs = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(costs, Integer.MAX_VALUE / 2);
        costs[start] = 0;
        visited[start] = true;
        while (true) {
            // 遍历边
            for (int[] singleRoad : singleRoads) {
                int u = singleRoad[0];
                int v = singleRoad[1];
                int w = singleRoad[2];
                costs[v] = Math.min(costs[v], costs[u] + w);
            }
            for (int[] doubleRoad : doubleRoads) {
                int u = doubleRoad[0];
                int v = doubleRoad[1];
                int w = doubleRoad[2];
                costs[v] = Math.min(costs[v], costs[u] + w);
                costs[u] = Math.min(costs[u], costs[v] + w);
            }
            // 找一个最小的
            int cost = Integer.MAX_VALUE;
            int cur = 0;
            for (int i = 0; i < costs.length; i++) {
                if (!visited[i] && costs[i] < cost) {
                    cost = costs[i];
                    cur = i;
                }
            }
            visited[cur] = true;
            if (cur == end) {
                return costs[cur];
            }
        }

    }

    public static void buildRoad(int[][] singleRoads, int[][] doubleRoads, int[] qs, int n, int s) {

    }

}
