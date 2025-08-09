package 程序员面试经典;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.06. 2出现的次数
 * @date: 2020/10/28 4:16 下午
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 *
 */
public class M17_06_hard_2出现的次数 {
    public int numberOf2sInRange(int n) {
        int res = 0;
        int mod = 1;
        while (mod < n) {
            int l = n / mod;
            int r = n % mod;
            res += (l + 7) / 10 * mod + (l % 10 == 2 ? 1 : 0) * (r + 1);
            mod *= 10;
        }
        return res;
    }
}




















