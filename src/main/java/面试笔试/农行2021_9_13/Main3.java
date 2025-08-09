package 面试笔试.农行2021_9_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/13 3:37 下午
 */
public class Main3 {


    public static void main(String[] args) {
        Main3 m = new Main3();
        m.splitArray(new int[]{3, 2, 2, 3, 1});
    }

    public int splitArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = 0; j < i; j++) {
                if (notOne(nums[j], nums[i - 1])) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public boolean notOne(int x, int y) {
        if (x == 1 || y == 1) {
            return false;
        }
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (x == y || y % x == 0) {
            return true;
        }

        for (int i = 2; i < x; i++) {
            if (x % i == 0 && y % i == 0) {
                return true;
            }
        }
        return false;
    }

}
