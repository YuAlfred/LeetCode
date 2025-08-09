package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 485. 最大连续1的个数
 * @date: 2021/2/15 11:44 上午
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M485_easy_最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                res = Math.max(temp, res);
                temp = 0;
            }
        }
        return res;
    }

}










