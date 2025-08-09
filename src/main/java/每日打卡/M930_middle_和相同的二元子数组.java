package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 930. 和相同的二元子数组
 * @date: 2021/7/8 12:30 上午
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M930_middle_和相同的二元子数组 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length + 1;
        int[] sums = new int[n];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + goal; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (sums[j] - sums[i] == goal) {
                    ans++;
                } else if (sums[j] - sums[i] > goal) {
                    break;
                }
            }
        }
        return ans;
    }


}
