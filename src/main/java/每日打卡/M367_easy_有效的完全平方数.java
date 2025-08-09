package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 367. 有效的完全平方数
 * @date: 2021/11/4 12:23 上午
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M367_easy_有效的完全平方数 {

    public boolean isPerfectSquare(int num) {
        int l = 1, r = 1000000;
        while (l <= r) {
            int m = (l + r) / 2;
            long ans = (long) m * m;
            if (ans == num) {
                return true;
            } else if (ans > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }


}
