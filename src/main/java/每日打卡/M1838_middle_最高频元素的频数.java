package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1838. 最高频元素的频数
 * @date: 2021/7/19 12:03 上午
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * <p>
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1838_middle_最高频元素的频数 {

    /**
     * 解法1 时间复杂度比较高
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            int j = i - 1;
            int curK = k;
            int curAns = 1;
            while (j >= 0 && curK >= 0) {
                curK -= (nums[i] - nums[j]);
                if (curK < 0) {
                    break;
                }
                curAns++;
                ans = Math.max(ans, curAns);
                j--;
            }
        }
        return ans;
    }


    /**
     * 解法二 滑动窗口 + 前缀和 更快
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSums = new int[n + 1];
        preSums[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
        int l = 0, r = 0;
        while (r < n) {
            // 先尝试扩大右边界
            if (r < n - 1 && (nums[r + 1] * (r - l + 2)) - (preSums[r + 2] - preSums[l]) <= k) {
                r++;
                continue;
            }
            //不行就整体右移动
            r++;
            l++;
        }
        return r - l + 1;
    }

}
