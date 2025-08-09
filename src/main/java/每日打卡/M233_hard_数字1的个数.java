package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 233. 数字 1 的个数
 * @date: 2021/8/13 9:51 下午
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M233_hard_数字1的个数 {


    public int countDigitOne(int n) {
        int bios = 1;
        int ans = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if (temp >= 1) {
                ans += temp * bios;
            }
            bios = (bios + temp) * 10;
        }
        return ans;
    }


}
