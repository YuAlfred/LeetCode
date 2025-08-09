package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 400. 第 N 位数字
 * @date: 2021/11/30 9:23 下午
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M400_middle_第N位数字 {

    public static void main(String[] args) {
        M400_middle_第N位数字 m = new M400_middle_第N位数字();
        System.out.println(m.findNthDigit(11));
    }

    public int findNthDigit(int n) {
        int start = 1, end = 9;
        int diff = 1;
        while ((end - start + 1) * diff < n) {
            n -= (end - start + 1) * diff;
            start *= 10;
            end *= 10;
            end += 9;
            diff++;
        }
        n--;
        int seq = start + n / diff;
        int mod = n % diff;
        String num = String.valueOf(seq);
        return num.charAt(mod) - '0';
    }

    public int findNthDigit1(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }


}
