package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/27 0:08
 * @description : 剑指 Offer 14- II. 剪绳子 II
 * @modified By  :
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M14_2 {

    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        long temp = 1;
        for (int i = 1; i < a; i++) {
            temp = (int) ((temp * 3) % (1e9 + 7));
        }
        switch (b) {
            case 0: {
                return (int) ((temp * 3) % (1e9 + 7));
            }
            case 1: {
                return (int) ((temp * 4) % (1e9 + 7));
            }
            default: {
                return (int) ((temp * 6) % (1e9 + 7));
            }
        }

    }

}
