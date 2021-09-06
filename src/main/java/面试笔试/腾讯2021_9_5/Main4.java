package 面试笔试.腾讯2021_9_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/5 9:16 下午
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();

        char[] cs = s.toCharArray();
        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            char c = cs[i - 1];
            dp[i] = Arrays.copyOf(dp[i - 1], 4);
            if (c == 'S') {
                dp[i][0] += 1;
            } else if (c == 'T') {
                dp[i][1] += ((i - 2 >= 0) && cs[i - 2] == 'S') ? (dp[i][0] - 1) : dp[i][0];
            } else if (c == 'A') {
                dp[i][2] += ((i - 3 >= 0) && cs[i - 2] == 'T') ? (dp[i][1] - dp[i - 3][0]) : dp[i][1];
            } else if (c == 'R') {
                dp[i][3] += ((i - 4 >= 0) && cs[i - 2] == 'A') ? (dp[i][2] - dp[i - 3][1]) : dp[i][2];
            }
        }

        System.out.println(dp[n][3]);
    }
}
