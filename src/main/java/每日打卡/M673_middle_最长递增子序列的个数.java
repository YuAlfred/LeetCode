package 每日打卡;

import java.util.Arrays;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/20 16:37
 * @description : 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M673_middle_最长递增子序列的个数 {

    public static void main(String[] args) {
        M673_middle_最长递增子序列的个数 m = new M673_middle_最长递增子序列的个数();
        System.out.println(m.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int[] ints : dp) {
            ints[0] = 1;
            ints[1] = 1;
        }
        int ans = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    } else if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                }
            }
            if (dp[i][0] > maxLength) {
                maxLength = dp[i][0];
                ans = dp[i][1];
            } else if (dp[i][0] == maxLength) {
                ans += dp[i][1];
            }
        }
        return ans;
    }

}
