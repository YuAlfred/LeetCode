package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/10/30 15:46
 * @description : 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M260_middle_只出现一次的数字III {

    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        int dig = 1;
        while ((dig & ans) == 0) {
            dig <<= 1;
        }
        int ans1 = 0, ans2 = 0;
        for (int num : nums) {
            if ((num & dig) == 0) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        return new int[]{ans1, ans2};
    }


}
