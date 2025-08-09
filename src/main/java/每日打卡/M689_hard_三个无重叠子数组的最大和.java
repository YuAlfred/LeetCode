package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 689. 三个无重叠子数组的最大和
 * @date: 2021/12/8 12:10 PM
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M689_hard_三个无重叠子数组的最大和 {

    public static void main(String[] args) {
        M689_hard_三个无重叠子数组的最大和 m = new M689_hard_三个无重叠子数组的最大和();
        int[] ints = m.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 2, 2, 2, 2}, 2);
        System.out.println(ints);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[][] dp = new int[3][n];
        // 只一个时
        for (int i = 1; i <= n - k; i++) {
            if (getKSum(preSum, dp[0][i - 1], k) >= getKSum(preSum, i, k)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = i;
            }
        }
        // 两个时
        dp[1][k] = k;
        for (int i = k + 1; i <= n - k; i++) {
            if (getKSum(preSum, dp[1][i - 1], k) + getKSum(preSum, dp[0][dp[1][i - 1] - k], k) >= getKSum(preSum, i, k) + getKSum(preSum, dp[0][i - k], k)) {
                dp[1][i] = dp[1][i - 1];
            } else {
                dp[1][i] = i;
            }
        }
        // 三个时
        dp[2][k * 2] = k * 2;
        for (int i = k * 2 + 1; i <= n - k; i++) {
            if (getKSum(preSum, dp[2][i - 1], k) + getKSum(preSum, dp[1][dp[2][i - 1] - k], k) + getKSum(preSum, dp[0][dp[1][dp[2][i - 1] - k] - k], k) >= getKSum(preSum, i, k) + getKSum(preSum, dp[1][i - k], k) + getKSum(preSum, dp[0][dp[1][i - k] - k], k)) {
                dp[2][i] = dp[2][i - 1];
            } else {
                dp[2][i] = i;
            }
        }
        return new int[]{dp[0][dp[1][dp[2][n - k] - k] - k], dp[1][dp[2][n - k] - k], dp[2][n - k]};
    }

    public int getKSum(int[] preSum, int index, int k) {
        if (index + k - 1 >= preSum.length) {
            return 0;
        }
        if (index == 0) {
            return preSum[k - 1];
        }
        return preSum[index + k - 1] - preSum[index - 1];
    }


}
