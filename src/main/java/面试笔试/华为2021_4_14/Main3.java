package 面试笔试.华为2021_4_14;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/14 6:56 下午
 */

import java.util.*;
public class Main3 {

    public static void main(String[] args) {
        // 读取输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] maxLengths = new int[n];
        for (int i = 0; i < n; i++) {
            maxLengths[i] = in.nextInt();
        }
        in.close();
        // END 输入
        // 创建dp数组做动态规划
        int[] dp = new int[n];
        // 给dp数组初始化值为int的最大值
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxLengths[i]; j++) {
                if (i + j < n) {
                    // 在 dp[i + j] 和 dp[i] + 1 取最小值
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        // 输出
        System.out.println(dp[n - 1]);
    }
}
