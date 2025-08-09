package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.util.Scanner;

public class Main4 {

    static int maxSum = 0;
    static int minIndex = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] maxAnts = new int[n + 1];
        maxAnts[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            maxAnts[i] = in.nextInt();
        }
        boolean[][] connected = new boolean[n + 1][n + 1];
        // for (int i = 0; i < n + 1; i++) {
        //     connected[0][i] = true;
        // }
        connected[0][1] = true;
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            connected[u][v] = true;
            connected[v][u] = true;
        }

        // //0 选 1-不选
        // int[][] maxSum = new int[n + 1][2];
        // int[][] minNode = new int[n + 1][2];
        //
        // maxSum[0][0] = 0;
        // minNode[0][0] = Integer.MAX_VALUE;
        // maxSum[0][1] = 0;
        // minNode[0][1] = Integer.MAX_VALUE;

        // for (int i = 1; i <= n; i++) {
        //     maxSum[i][0] = maxAnts[i];
        //     minNode[i][0] = i;
        //     maxSum[i][1] = 0;
        //     minNode[i][1] = Integer.MAX_VALUE;
        //     for (int j = i - 1; j >= 0; j--) {
        //         if (connected[j][i]) {
        //             maxSum[i][0] = Math.max(maxSum[j][1] + maxSum[i][0], maxSum[i][0]);
        //             maxSum[i][1] = Math.max(maxSum[j][1], maxSum[i][0]);
        //             maxSum[i][1] = Math.max(maxSum[j][0], maxSum[i][0]);
        //
        //         }
        //     }
        // }

        dfs(maxAnts, connected, 0, 0, Integer.MAX_VALUE, false);
        System.out.println(maxSum);
        System.out.println(minIndex);

        in.close();
    }

    public static void dfs(int[] maxAnts, boolean[][] connected, int index, int sum, int min, boolean prechecked) {

        if (sum > maxSum) {
            maxSum = sum;
            minIndex = min;
        } else if (sum == maxSum && min > minIndex) {
            minIndex = min;
        }
        if (index > maxAnts.length) {
            return;
        }

        for (int i = index + 1; i < maxAnts.length; i++) {
            if (connected[index][i]) {
                //选
                if (!prechecked) {
                    dfs(maxAnts, connected, i, sum + maxAnts[i], Math.min(min, maxAnts[i]), true);
                }
                //不选
                dfs(maxAnts, connected, i, sum, min, false);
            }
        }

    }
}
