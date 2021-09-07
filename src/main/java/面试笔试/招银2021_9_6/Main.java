package 面试笔试.招银2021_9_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/6 4:11 下午
 */
public class Main {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int start = in.nextInt();
        int target = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        in.close();

        // 拆路线合成图
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("]", "");

        String[] roadsS = s.split(",");
        List<int[]> roads = new ArrayList<>();

        for (int i = 0; i < roadsS.length; ) {
            int ps = Integer.parseInt(roadsS[i++]);
            int pt = Integer.parseInt(roadsS[i++]);
            int pCost = Integer.parseInt(roadsS[i++]);
            int[] road = new int[]{ps, pt, pCost};
            roads.add(road);
        }

        int[] costs = new int[m];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;
        for (int i = 0; i <= k; i++) {
            int[] newCosts = Arrays.copyOf(costs, costs.length);
            for (int[] road : roads) {
                if (costs[road[0]] != Integer.MAX_VALUE) {
                    newCosts[road[1]] = Math.min(newCosts[road[1]], costs[road[0]] + road[2]);
                }
            }
            costs = newCosts;
        }
        System.out.println(costs[target] == Integer.MAX_VALUE ? -1 : costs[target]);
    }

}
