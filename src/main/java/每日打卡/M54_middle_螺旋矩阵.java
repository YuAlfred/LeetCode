package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 54. 螺旋矩阵
 * @date: 2021/3/15 9:17 上午
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M54_middle_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int length = n * m;

        int count = 0;

        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (count < length) {
            //向右
            for (int i = left; i <= right && count < length; i++) {
                ans.add(matrix[top][i]);
                count++;
            }
            top++;
            //向下
            for (int i = top; i <= bottom && count < length; i++) {
                ans.add(matrix[i][right]);
                count++;
            }
            right--;
            //向左
            for (int i = right; i >= left && count < length; i--) {
                ans.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            //向上
            for (int i = bottom; i >= top && count < length; i--) {
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }

        return ans;
    }

}
