package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.util.Scanner;

public class Main5 {

    public static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] height = new int[n];
        boolean[] visited = new boolean[n];
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

        for (int i = 0; i < n; i++) {
            dfs(height, connected, visited, i, 1);
        }

        System.out.println(sum);
        in.close();
    }

    public static void dfs(int[] height, boolean[][] connected, boolean[] visited, int index, int tempSum) {
        sum = Math.max(sum, tempSum);
        for (int i = 0; i < height.length; i++) {
            if (i == index || visited[i]) {
                continue;
            }
            if (connected[index][i]) {
                if (height[i] < height[index]) {
                    visited[i] = true;
                    dfs(height, connected, visited, i, tempSum + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
