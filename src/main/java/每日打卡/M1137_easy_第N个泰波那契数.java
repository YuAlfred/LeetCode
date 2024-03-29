package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1137. 第 N 个泰波那契数
 * @date: 2021/8/8 11:02 下午
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1137_easy_第N个泰波那契数 {

    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t1;
    }


}
