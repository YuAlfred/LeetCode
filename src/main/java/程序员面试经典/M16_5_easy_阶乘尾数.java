package 程序员面试经典;

import java.math.BigInteger;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 7:09 下午
 * @description : 面试题 16.05. 阶乘尾数
 * @modified By  :
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_5_easy_阶乘尾数 {
    /**
     * 只要算出有多少个5的倍数即可
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int m5 = 0;
        while (n > 0) {
            m5 += n / 5;
            n /= 5;
        }
        return m5;
    }
}














