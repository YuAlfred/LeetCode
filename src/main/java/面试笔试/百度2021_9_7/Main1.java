package 面试笔试.百度2021_9_7;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 7:31 下午
 */
public class Main1 {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        in.close();

        // 输出
        for (int i = 0; i < n; i++) {
            // 每行输出k次
            for (int i1 = 0; i1 < k; i1++) {
                // 每个输出k次
                for (int j = 0; j < n; j++) {
                    for (int i2 = 0; i2 < k; i2++) {
                        System.out.print(graph[i][j] + " ");
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
