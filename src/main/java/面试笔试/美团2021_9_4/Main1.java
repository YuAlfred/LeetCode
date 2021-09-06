package 面试笔试.美团2021_9_4;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/4 5:22 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        if (n <= 2) {
            System.out.println(n * 2);
            return;
        }

        int mod = 998244353;

        int[][] dp = new int[n][4];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        for (int i = 2; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][1] = dp[i - 1][0];
            dp[i][2] = dp[i - 1][3];
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
        }

        System.out.println(((dp[n - 1][0] + dp[n - 1][1]) % mod + (dp[n - 1][2] + dp[n - 1][3]) % mod) % mod);

    }

}
