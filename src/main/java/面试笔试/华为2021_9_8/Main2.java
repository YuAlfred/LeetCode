package 面试笔试.华为2021_9_8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/8 7:19 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] ss = s.split(",");
        int m = Integer.parseInt(ss[0]);
        int n = Integer.parseInt(ss[1]);
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        in.close();

        // 如果开始或结尾有0直接结束
        if (graph[0][0] == 0 || graph[m - 1][n - 1] == 0) {
            System.out.println(-1);
            return;
        }
        int[][] times = new int[m][n];
        for (int[] time : times) {
            Arrays.fill(time, Integer.MAX_VALUE);
        }
        times[0][0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int z = 0; z < size; z++) {
                int p = queue.poll();
                // 开始跳
                int x = getX(p);
                int y = getY(p);
                int k = graph[x][y];
                if (k != 0) {
                    for (int i = x; i <= (x + k) && i < m; i++) {
                        if (graph[i][y] == 0) {
                            continue;
                        }
                        int newTime = times[x][y] + 1;
                        if (newTime < times[i][y]) {
                            times[i][y] = newTime;
                            queue.add(getP(i, y));
                        }
                    }
                    for (int j = y; j <= (y + k) && j < n; j++) {
                        if (graph[x][j] == 0) {
                            continue;
                        }
                        int newTime = times[x][y] + 1;
                        if (newTime < times[x][j]) {
                            times[x][j] = newTime;
                            queue.add(getP(x, j));
                        }
                    }
                }
            }
        }

        System.out.println(times[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : times[m - 1][n - 1]);
    }

    public static int getP(int x, int y) {
        return x * 1000 + y;
    }

    public static int getX(int p) {
        return p / 1000;
    }

    public static int getY(int p) {
        return p % 1000;
    }


}
