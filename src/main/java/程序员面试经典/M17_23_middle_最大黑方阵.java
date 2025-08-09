package 程序员面试经典;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.23. 最大黑方阵
 * @date: 2020/10/30 4:20
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 * <p>
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 * <p>
 * 输入:
 * [
 *    [0,1,1],
 *    [1,0,1],
 *    [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 * <p>
 * matrix.length == matrix[0].length <= 200
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-black-square-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_23_middle_最大黑方阵 {

    public static void main(String[] args) {
        M17_23_middle_最大黑方阵 m = new M17_23_middle_最大黑方阵();
        m.findSquare(new int[][]{{1, 0, 1}, {0, 0, 1}, {0, 0, 1}});
    }


    public int[] findSquare(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        //0向右，1向下
        int[][][] dp = new int[matrix.length][matrix.length][2];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    if (i == matrix.length - 1) {
                        dp[i][j][1] = 1;
                    } else {
                        dp[i][j][1] = dp[i + 1][j][1] + 1;
                    }
                    if (j == matrix.length - 1) {
                        dp[i][j][0] = 1;
                    } else {
                        dp[i][j][0] = dp[i][j + 1][0] + 1;
                    }
                }
            }
        }
        int size = 0, resI = -1, resJ = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int tempSize = check(matrix, i, j, dp, size);
                if (tempSize > size) {
                    size = tempSize;
                    resI = i;
                    resJ = j;
                }
            }
        }
        return size != 0 ? new int[]{resI, resJ, size} : new int[0];
    }

    public int check(int[][] matrix, int i, int j, int[][][] dp, int minSize) {
        if (dp[i][j][0] <= minSize || dp[i][j][1] <= minSize) {
            return 0;
        }
        int curSize = 0;
        int size = minSize;
        int m = i + minSize;
        int n = j + minSize;
        while ((m < dp[i][j][1] + i) && (n < dp[i][j][0] + j)) {
            if (dp[m][j][0] > size && dp[i][n][1] > size) {
                size++;
                m++;
                n++;
                curSize = size;
            } else {
                m++;
                n++;
                size++;
            }
        }
        return curSize;
    }

}











