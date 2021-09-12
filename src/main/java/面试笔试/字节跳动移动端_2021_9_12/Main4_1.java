package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.Scanner;

public class Main4_1 {

    public static int ans = 0;
    public static int cur = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            ans = 0;
            cur = 0;
            dfs(nums, n, 0, 0);
            System.out.println(ans);
        }
        in.close();
    }

    public static void dfs(int[] nums, int n, int index, int curTotal) {
        if (index >= n) {
            return;
        }
        if (nums[index] >= 0) {
            cur++;
            curTotal += nums[index];
            ans = Math.max(cur, ans);
            dfs(nums, n, index + 1, curTotal);
            cur--;
        } else {
            // 不取
            dfs(nums, n, index + 1, curTotal);

            // 取
            if (curTotal + nums[index] >= 0) {
                cur++;
                curTotal += nums[index];
                ans = Math.max(cur, ans);
                dfs(nums, n, index + 1, curTotal);
                cur--;
            }
        }
    }

}
