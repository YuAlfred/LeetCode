package 每日打卡;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/22 23:33
 * @description : 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M384_middle_打乱数组 {

    class Solution {

        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] shuffleNums = Arrays.copyOf(nums, nums.length);
            Random random = new Random();
            for (int i = nums.length - 1; i > 0; i--) {
                swap(shuffleNums, i, random.nextInt(i + 1));
            }
            return shuffleNums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
