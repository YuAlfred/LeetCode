package 程序员面试经典;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.09. 第 k 个数
 * @date: 2020/10/28 6:29 下午
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_09_middle_第k个数 {

    public int getKthMagicNumber(int k) {
        int res = 1;
        int[] nums = new int[k];
        nums[0] = 1;
        int n3 = 0, n5 = 0, n7 = 0;
        for (int i = 1; i < k; i++) {
            int next = Math.min(Math.min(nums[n3] * 3, nums[n5] * 5), nums[n7] * 7);
            nums[i] = next;
            if (next == nums[n3] * 3) {
                n3++;
            }
            if (next == nums[n5] * 5) {
                n5++;
            }
            if (next == nums[n7] * 7) {
                n7++;
            }
        }
        return nums[k - 1];
    }
}










