package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 879. 盈利计划
 * @date: 2021/6/11 4:14 下午
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M879_hard_盈利计划 {

    public static void main(String[] args) {
        M879_hard_盈利计划 m = new M879_hard_盈利计划();
        m.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3});
    }

    public int mod = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int workNum = profit.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= workNum; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    // 第i个工作做
                    int members = j - group[i - 1], earn = Math.max(0, k - profit[i - 1]);
                    if (members >= 0 && earn >= 0) {
                        dp[j][k] = (dp[members][earn] + dp[j][k]) % mod;
                    }
                }
            }
        }
        return dp[n][minProfit];
    }

}















