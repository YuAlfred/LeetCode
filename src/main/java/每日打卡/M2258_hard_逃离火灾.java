package 每日打卡;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2023/11/9 00:08
 * @description: 逃离火灾
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
 * <p>
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
 * <p>
 * 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 109 。
 * <p>
 * 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
 * <p>
 * 如果两个格子有共同边，那么它们为 相邻 格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
 * 输出：3
 * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 * 你仍然可以安全到达安全屋。
 * 停留超过 3 分钟会让你无法安全到达安全屋。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 * 输出：-1
 * 解释：上图展示了你马上开始朝安全屋移动的情形。
 * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 * 所以返回 -1 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 * 输出：1000000000
 * 解释：上图展示了初始网格图。
 * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 * 所以返回 109 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 300
 * 4 <= m * n <= 2 * 104
 * grid[i][j] 是 0 ，1 或者 2 。
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class M2258_hard_逃离火灾 {

    public int maximumMinutes(int[][] grid) {

    }

    // 对单个图的火焰扩散
    public void exposeForOneGrid(int[][] grid, boolean[][] newFire, int i, int j) {
        if (grid[i][j] != 1 || newFire[i][j]) {
            return;
        }

        // 上
        if (i > 0 && grid[i - 1][j] == 0) {
            grid[i - 1][j] = 1;
            newFire[i - 1][j] = true;
        }
        // 下
        if (i + 1 < grid.length && grid[i + 1][j] == 0) {
            grid[i + 1][j] = 1;
            newFire[i + 1][j] = true;
        }
        // 左
        if (j > 0 && grid[i][j - 1] == 0) {
            grid[i][j - 1] = 1;
            newFire[i][j - 1] = true;
        }
        // 右
        if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
            grid[i][j + 1] = 1;
            newFire[i][j + 1] = true;
        }
    }

    // 整个图的火焰扩散
    public int[][] expose(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
        }

        boolean[][] newFire = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                exposeForOneGrid(newGrid, newFire, i, j);
            }
        }

        return newGrid;
    }

    // 寻路
    public int findWay(int[][] grid){

    }


}
