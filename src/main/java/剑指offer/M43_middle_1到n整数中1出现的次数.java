package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/16 20:38
 * @description : 剑指 Offer 43. 1～n整数中1出现的次数
 * @modified By  :
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M43_middle_1到n整数中1出现的次数 {

    public static void main(String[] args) {
        System.out.println(countDigitOne(1410065408));
    }


    public static int countDigitOne(int n) {
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long driver = i * 10;
            res += (n / driver) * i + Math.min(Math.max((n % driver) - i + 1, 0), i);
        }
        return res;
    }

}












