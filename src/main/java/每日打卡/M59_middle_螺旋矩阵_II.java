package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 59. 螺旋矩阵 II
 * @date: 2021/3/16 10:26 上午
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M59_middle_螺旋矩阵_II {

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int left = 0, top = 0, bottom = n - 1, right = n - 1;
        int count = 1;
        int sum = n * n + 1;
        while (count < sum) {
            //向右
            for (int i = left; i <= right && count < sum; i++) {
                ans[top][i] = count;
                count++;
            }
            top++;
            //向下
            for (int i = top; i <= bottom && count < sum; i++) {
                ans[i][right] = count;
                count++;
            }
            right--;
            //向左
            for (int i = right; i >= left && count < sum; i--) {
                ans[bottom][i] = count;
                count++;
            }
            bottom--;
            //上
            for (int i = bottom; i >= top && count < sum; i--) {
                ans[i][left] = count;
                count++;
            }
            left++;
        }
        return ans;
    }

}
