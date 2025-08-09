package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 576. 出界的路径数
 * @date: 2021/8/15 9:04 下午
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * <p>
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M576_middle_出界的路径数 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[2][m][n];
        int mod = (int) (1e9 + 7);

        for (int i = 1; i <= maxMove; i++) {
            int ri = i % 2;
            int pi = (i + 1) % 2;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    dp[ri][j][k] = 0;
                    dp[ri][j][k] += (j - 1) >= 0 ? dp[pi][j - 1][k] : 1;
                    dp[ri][j][k] += (j + 1) < m ? dp[pi][j + 1][k] : 1;
                    dp[ri][j][k] %= mod;
                    dp[ri][j][k] += (k - 1) >= 0 ? dp[pi][j][k - 1] : 1;
                    dp[ri][j][k] %= mod;
                    dp[ri][j][k] += (k + 1) < n ? dp[pi][j][k + 1] : 1;
                    dp[ri][j][k] %= mod;
                }
            }
        }
        return dp[maxMove % 2][startRow][startColumn];

    }


}
