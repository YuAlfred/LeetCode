package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1034. 边界着色
 * @date: 2021/12/7 11:04 PM
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 * <p>
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * <p>
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1034_middle_边界着色 {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int needColor = grid[row][col];
        dfs(grid, row, col, needColor);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = needColor;
                }
                if (grid[i][j] == -2) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] grid, int row, int col, int color) {
        // 如果是边界
        if ((row == 0)  // 上边界
                || (grid[row - 1][col] != color && grid[row - 1][col] != -1 && grid[row - 1][col] != -2)
                // 下边界
                || (row == grid.length - 1)
                || (grid[row + 1][col] != color && grid[row + 1][col] != -1 && grid[row + 1][col] != -2)
                // 左边界
                || (col == 0)
                || (grid[row][col - 1] != color && grid[row][col - 1] != -1 && grid[row][col - 1] != -2)
                // 右边界
                || (col == grid[0].length - 1)
                || (grid[row][col + 1] != color && grid[row][col + 1] != -1 && grid[row][col + 1] != -2)) {

            grid[row][col] = -2;
        } else {
            grid[row][col] = -1;
        }
        // 上
        if (row > 0 && grid[row - 1][col] == color) {
            dfs(grid, row - 1, col, color);
        }
        // 下
        if (row < grid.length - 1 && grid[row + 1][col] == color) {
            dfs(grid, row + 1, col, color);
        }
        // 左
        if (col > 0 && grid[row][col - 1] == color) {
            dfs(grid, row, col - 1, color);
        }
        //右
        if (col < grid[0].length - 1 && grid[row][col + 1] == color) {
            dfs(grid, row, col + 1, color);
        }
    }


}
