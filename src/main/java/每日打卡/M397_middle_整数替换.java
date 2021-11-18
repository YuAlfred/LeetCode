package 每日打卡;

import java.util.HashMap;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/19 1:00
 * @description : 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M397_middle_整数替换 {

    public int integerReplacement(int n) {
        HashMap<Integer, Integer> times = new HashMap<>();
        times.put(1, 0);
        if (n == Integer.MAX_VALUE) {
            return Math.min(getTimes((n - 1) / 2, times), getTimes((n - 1) / 2 + 1, times));
        }
        return getTimes(n, times);
    }

    public int getTimes(int n, HashMap<Integer, Integer> times) {
        if (times.containsKey(n)) {
            return times.get(n);
        }
        // 奇数
        if ((n & 1) == 1) {
            int ans = Math.min(getTimes(n + 1, times), getTimes(n - 1, times)) + 1;
            times.put(n, ans);
            return ans;
        } else {
            return getTimes(n / 2, times) + 1;
        }
    }


}
