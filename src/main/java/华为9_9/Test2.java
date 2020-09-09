package 华为9_9;


/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/9 7:08 下午
 * @description : 完美排列
 * @modified By  :
 */

import java.util.*;

public class Test2 {

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] qur = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                qur[i][j] = in.nextInt();
            }
        }
        int[][] memo = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ans = Math.max(ans, dfs(qur, i, j, memo));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int[][] matrix, int row, int column, int[][] memo) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 &&
                newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
