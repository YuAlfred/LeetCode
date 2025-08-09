package 面试笔试.腾讯2021_8_22;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/22 9:04 下午
 */
public class Main5 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        in.close();

        int[][][] dp = new int[n][n][2];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j][0] = Math.min(dp[i + 1][j][0] + Math.abs(A[i] - A[i + 1]), dp[i + 1][j][1] + Math.abs(A[i] - A[j]));
                dp[i][j][1] = Math.min(dp[i][j - 1][0] + Math.abs(A[i] - A[j]), dp[i][j - 1][1] + Math.abs(A[j - 1] - A[j]));
            }
        }
        System.out.println(Math.min(dp[0][n - 1][0], dp[0][n - 1][1]));
    }
}
