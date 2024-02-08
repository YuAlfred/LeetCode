package 面试笔试.字节飞书2022_2_27;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2022/2/27 6:35 PM
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        // true为墙
        boolean[][] graph = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) == '1';
            }
        }
        int x = 0, y = 0;
        // 开始走
        String steps = in.next();
        for (char step : steps.toCharArray()) {
            switch (step) {
                // 向上
                case 'W':
                    if (x == 0 || graph[x - 1][y]) {
                        continue;
                    } else {
                        x--;
                    }
                    break;
                // 向下
                case 'S':
                    if (x == graph.length - 1 || graph[x + 1][y]) {
                        continue;
                    } else {
                        x++;
                    }
                    break;
                // 向左
                case 'A':
                    if (y == 0 || graph[x][y - 1]) {
                        continue;
                    } else {
                        y--;
                    }
                    break;
                // 向右
                case 'D':
                    if (y == graph[0].length - 1 || graph[x][y + 1]) {
                        continue;
                    } else {
                        y++;
                    }
                    break;
            }
        }
        in.close();

        System.out.println((x + 1) + " " + (y + 1));
    }

}
