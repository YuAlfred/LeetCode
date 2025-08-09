package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 74. 搜索二维矩阵
 * @date: 2021/3/30 9:15 上午
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M74_middle_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        //  先找行
        int start = -1;
        int end = n - 1;
        int middle;
        while (start < end) {
            middle = (start + end + 1) / 2;
            if (matrix[middle][0] < target) {
                start = middle;
            } else if (matrix[middle][0] > target) {
                end = middle - 1;
            } else {
                return true;
            }
        }
        int row = start;
        if (row < 0) {
            return false;
        }
        // 再找列
        start = 0;
        end = m - 1;
        while (start <= end) {
            middle = (start + end) / 2;
            if (matrix[row][middle] < target) {
                start = middle + 1;
            } else if (matrix[row][middle] > target) {
                end = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
