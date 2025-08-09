package 每日打卡;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2024/8/13 22:17
 * @description:
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 *
 * Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1]
 *
 * 输出：true
 *
 * 解释：
 *
 * 只有一个元素，所以答案为 true。
 *
 * 示例 2：
 *
 * 输入：nums = [2,1,4]
 *
 * 输出：true
 *
 * 解释：
 *
 * 只有两对相邻元素： (2,1) 和 (1,4)，它们都包含了奇偶性不同的数字，因此答案为 true。
 *
 * 示例 3：
 *
 * 输入：nums = [4,3,1,6]
 *
 * 输出：false
 *
 * 解释：
 *
 * nums[1] 和 nums[2] 都是奇数。因此答案为 false。
 */
public class M3151_easy_特殊数组I {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            if(((nums[i] ^ nums[i+1]) & 1) == 0){
                return false;
            }
        }
        return true;
    }
}







