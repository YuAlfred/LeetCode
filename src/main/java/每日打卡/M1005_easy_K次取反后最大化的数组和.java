package 每日打卡;

import java.util.Arrays;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/4 0:49
 * @description : 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1005_easy_K次取反后最大化的数组和 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        int min = nums[0];
        int count = 0;
        for (int num : nums) {
            count += num;
            min = Math.min(min, num);
        }
        if ((k & 1) == 1) {
            count -= min * 2;
        }
        return count;
    }


}
