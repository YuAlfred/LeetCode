package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.util.Scanner;

public class Main5_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            connected[u][v] = true;
            connected[v][u] = true;
        }

        int max = 0;
        //0-正向，1-反向
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (connected[j][i] && height[i] < height[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                    max = Math.max(max, dp[i][0]);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (connected[i][j] && height[i] < height[j]) {
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                    max = Math.max(max, dp[i][1]);
                }
            }
        }

        System.out.println(max);
        in.close();
    }

}
