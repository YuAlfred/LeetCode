package 面试笔试.百度算法2021_9_14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/14 9:45 下午
 */
public class Main1 {

    /**
     * 尝试思考未果，参考网上的代码思路，整理如下：
     * <p>
     * 首先按照时间从小到达排序，然后依次遍历，取当前游戏的截止时间
     * 设立一个最小堆放游戏积分，每次把当前游戏积分放进去
     * 如果堆长度*10大于了截止时间就poll一个即可。
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] games = new int[n][2];
        for (int i = 0; i < n; i++) {
            games[i][0] = in.nextInt();
            games[i][1] = in.nextInt();
        }
        in.close();

        // 按时间从小到大排序
        Arrays.sort(games, Comparator.comparingInt(o -> o[0]));

        // 选择的游戏的积分的小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int ans = 0;
        // 遍历每个游戏
        for (int[] game : games) {
            int deadTime = game[0];
            // 直接把此游戏积分放到堆中
            queue.add(game[1]);
            ans += game[1];
            // 如果堆中游戏时间总和超过了当前截止时间就抛出来一个积分最小的
            if (deadTime < queue.size() * 10) {
                ans -= queue.poll();
            }
        }

        System.out.println(ans);
    }
}
