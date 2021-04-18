package 面试笔试.腾讯后台2021_4_18;


/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/18 7:39 下午
 */

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int n = in.nextInt();
            // Game[] games = new Game[n];
            int[][] games = new int[n][2];
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                games[i][0] = t;
            }
            for (int i = 0; i < n; i++) {
                int w = in.nextInt();
                games[i][1] = w;
            }

            Arrays.sort(games, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            });

            int ans = 0;
            int time = 0;
            for (int[] g : games) {
                time++;
                if (g[0] < time) {
                    time--;
                    ans += g[1];
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
