package 程序员面试经典;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.24. 最大子矩阵
 * @date: 2020/11/3 10:45 上午
 * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 * <p>
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 *    [-1,0],
 *    [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 *  
 * <p>
 * 说明：
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-submatrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_24_hard_最大子矩阵 {
    public int[] getMaxMatrix(int[][] matrix) {
        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        int maxSum = Integer.MIN_VALUE;
        int tr1 = 0, tr2 = 0, tc1 = 0, tc2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            tr1 = i;
            int[] b = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                int sum = Integer.MIN_VALUE;
                for (int k = 0; k < matrix[0].length; k++) {
                    b[k] += matrix[j][k];
                    if (sum < 0) {
                        sum = b[k];
                        tc1 = k;
                    } else {
                        sum += b[k];
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        r1 = i;
                        r2 = j;
                        c1 = tc1;
                        c2 = k;
                    }
                }
            }
        }
        return new int[]{r1, c1, r2, c2};
    }
}













