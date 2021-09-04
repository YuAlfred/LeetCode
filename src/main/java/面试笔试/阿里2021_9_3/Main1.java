package 面试笔试.阿里2021_9_3;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/3 7:00 下午
 */
public class Main1 {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String A = in.next();
        String B = in.next();
        in.close();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = a[i] == b[i] ? 0 : 1;
                } else {
                    int ans = Integer.MAX_VALUE;
                    if (equals(a, b, i, j)) {
                        ans = 0;
                    } else if (oneChange(a, b, i, j)) {
                        ans = 1;
                    } else {
                        for (int k = i; k <= j; k++) {
                            int temp = a[k] == b[k] ? 0 : 1;
                            if (k > i) {
                                temp += dp[i][k - 1];
                            }
                            if (k < j) {
                                temp += dp[k + 1][j];
                            }
                            ans = Math.min(ans, temp);
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    public static boolean equals(char[] a, char[] b, int l, int r) {
        while (l <= r) {
            if (a[l] != a[r]) {
                return false;
            }
            l++;
        }
        return true;
    }

    public static boolean oneChange(char[] a, char[] b, int l, int r) {
        while (l <= r) {
            if (a[l] == a[r]) {
                return false;
            }
            l++;
        }
        return true;
    }

}
