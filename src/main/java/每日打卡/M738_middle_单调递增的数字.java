package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 738. 单调递增的数字
 * @date: 2020/12/15 4:32 下午
 * <p>
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M738_middle_单调递增的数字 {

    public int monotoneIncreasingDigits(int N) {
        char[] n = String.valueOf(N).toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < n.length - 1; i++) {
            if (max < n[i]) {
                max = n[i];
                idx = i;
            }
            if (n[i] > n[i + 1]) {
                n[idx] -= 1;
                for (int j = idx + 1; j < n.length; j++) {
                    n[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(String.valueOf(n));
    }

}












