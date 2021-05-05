package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/5/5 10:06 下午
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M740_middle_删除并获得点数 {


    public int deleteAndEarn(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i][0] = dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] == nums[i - 1] + 1) {
                dp[i][0] = dp[i - 1][1] + nums[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][0] = dp[i][0] + nums[i];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


}
