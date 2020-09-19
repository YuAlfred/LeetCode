package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/27 12:28
 * @description : 剑指 Offer 16. 数值的整数次方
 * @modified By  :
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_middle_快速幂 {

    public static void main(String[] args) {
        M16_middle_快速幂 m16快速幂 = new M16_middle_快速幂();
        m16快速幂.myPow(2, -2147483648);
    }

    public double myPow(double x, int n) {

        long abN = Math.abs((long) n);


        double result = 1;
        while (abN > 0) {
            if ((abN & 1) != 0) {
                result *= x;
            }
            abN >>= 1;
            x *= x;
        }
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }
}











