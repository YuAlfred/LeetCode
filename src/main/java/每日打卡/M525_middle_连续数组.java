package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 525. 连续数组
 * @date: 2021/6/3 9:27 上午
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M525_middle_连续数组 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                sum[i] = sum[i - 1] - 1;
            } else {
                sum[i] = sum[i - 1] + 1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }else {
                int prevIndex = map.get(sum[i]);
                maxLength = Math.max(maxLength, i - prevIndex);
            }
        }
        return maxLength;
    }


}










