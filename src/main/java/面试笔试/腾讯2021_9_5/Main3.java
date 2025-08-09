package 面试笔试.腾讯2021_9_5;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/5 5:27 下午
 */
public class Main3 {

    public static int[][] DIRS = new int[][]{{-1, -2}, {1, -2}, {-1, 2}, {1, 2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}};

    public static void main(String[] args) {

        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int startX = in.nextInt() - 1;
        int startY = in.nextInt() - 1;
        int startP = getP(startX, startY);
        in.close();

        //
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startP);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                if (visited.contains(p)) {
                    continue;
                }else {
                    visited.add(p);
                }
                int x = getX(p);
                int y = getY(p);
                for (int[] dir : DIRS) {
                    int nX = x + dir[0];
                    int nY = y + dir[1];
                    // 如果能跳且没跳过
                    if (nX >= 0 && nX < n && nY >= 0 && nY < m && grid[x][y] != grid[nX][nY] && !visited.contains(getP(nX, nY))) {
                        queue.add(getP(nX, nY));
                    }
                }
            }
        }
        System.out.println(visited.size());

    }

    public static int getX(int p) {
        return p / 10000;
    }

    public static int getY(int p) {
        return p % 10000;
    }

    public static int getP(int x, int y) {
        return x * 10000 + y;
    }

}
