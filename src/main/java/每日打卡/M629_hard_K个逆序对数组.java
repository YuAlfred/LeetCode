package 每日打卡;

import java.util.Arrays;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/11 0:33
 * @description : 629. K个逆序对数组
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * <p>
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 * 示例 2:
 * <p>
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释:
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 * 说明:
 * <p>
 *  n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M629_hard_K个逆序对数组 {

    public static void main(String[] args) {
        M629_hard_K个逆序对数组 m = new M629_hard_K个逆序对数组();
        System.out.println(m.kInversePairs(3, 1));
    }

    public int kInversePairs(int n, int k) {
        int mod = (int) 1e9 + 7;
        // 从i到n达到j
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) - (j - i >= 0 ? dp[i - 1][j - i] : 0) + dp[i - 1][j];
                if (dp[i][j] > mod) {
                    dp[i][j] -= mod;
                } else if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
            }
        }
        return dp[n][k];
    }


}
