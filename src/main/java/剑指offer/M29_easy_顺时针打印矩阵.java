package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/3 16:14
 * @description : 剑指 Offer 29. 顺时针打印矩阵
 * @modified By  :
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M29_easy_顺时针打印矩阵 {

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int xStart = 0, yStart = 0, xEnd = matrix.length - 1, yEnd = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (true) {
            //向右
            for (int j = yStart; j <= yEnd; j++) {
                res[index++] = matrix[xStart][j];
            }
            if (++xStart > xEnd) {
                break;
            }
            //向下
            for (int i = xStart; i <= xEnd; i++) {
                res[index++] = matrix[i][yEnd];
            }
            if (--yEnd < yStart) {
                break;
            }
            //向左
            for (int j = yEnd; j >= yStart; j--) {
                res[index++] = matrix[xEnd][j];
            }
            if (--xEnd < xStart) {
                break;
            }
            //向上
            for (int i = xEnd; i >= xStart; i--) {
                res[index++] = matrix[i][yStart];
            }
            if (++yStart > yEnd) {
                break;
            }
        }
        return res;


    }

}






