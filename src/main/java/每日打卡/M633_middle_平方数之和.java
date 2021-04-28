package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 633. 平方数之和
 * @date: 2021/4/28 9:22 上午
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M633_middle_平方数之和 {

    public boolean judgeSquareSum(int c) {

        for (long i = 0; i * i <= c; i++) {
            double d = Math.sqrt(c - (i * i));
            if (d == (int) d) {
                return true;
            }
        }
        return false;

    }


}
