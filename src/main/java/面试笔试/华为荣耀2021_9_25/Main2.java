package 面试笔试.华为荣耀2021_9_25;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/25 5:58 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] origin = new String[n];
        for (int i = 0; i < n; i++) {
            origin[i] = in.next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += minOp(origin[i], in.next());
        }
        in.close();
        System.out.println(ans);
    }

    public static int minOp(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;
                int equal = 0;
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    equal = 1;
                }
                int leftUp = dp[i - 1][j - 1] + equal;
                dp[i][j] = Math.min(Math.min(left, up), leftUp);
            }
        }
        return dp[n1][n2];
    }

}
