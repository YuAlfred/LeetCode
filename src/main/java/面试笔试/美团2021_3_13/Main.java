package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] before = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                before[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(before[j][i]+" ");
            }
            System.out.println();
        }

        in.close();
    }
}
