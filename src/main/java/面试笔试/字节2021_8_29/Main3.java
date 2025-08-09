package 面试笔试.字节2021_8_29;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/29 10:10 上午
 */
public class Main3 {

    public static int[][][] dir = new int[][][]{{{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{-1, 1}, {1, -1}}, {{-1, -1}, {1, 1}}};

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        in.close();

        // 遍历找到结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && haveFive(grid, i, j)) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }
    }

    public static boolean haveFive(int[][] grid, int x, int y) {
        int n = grid.length;
        for (int[][] ways : dir) {
            int count = 0;
            for (int[] way : ways) {
                int i = x + way[0];
                int j = y + way[1];
                while (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 1) {
                    count++;
                    i += way[0];
                    j += way[1];
                }
            }
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }


}
