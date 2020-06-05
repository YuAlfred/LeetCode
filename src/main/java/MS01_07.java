/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/7 2:20 下午
 * @description : 面试题 01.07. 旋转矩阵
 * @modified By  :
 */
public class MS01_07 {

    public void rotate(int[][] matrix) {
        // 先水平翻转
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < (matrix.length / 2); j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = temp;
            }
        }
        // 然后沿对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MS01_07 m = new MS01_07();
        m.rotate(matrix);
    }

}
