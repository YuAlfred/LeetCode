package 每日打卡;

import java.util.Stack;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 456. 132模式
 * @date: 2021/3/24 9:10 上午
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 4]
 * <p>
 * 输出: False
 * <p>
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 * <p>
 * 输入: [3, 1, 4, 2]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 * <p>
 * 输入: [-1, 3, 2, 0]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M456_middle_132模式 {

    public boolean find132pattern(int[] nums) {

        int n = nums.length;

        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                if (min[i] < nums[stack.peek()]) {
                    return true;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return false;
    }

}
