package 面试笔试.腾讯算法2021_4_18;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/18 9:13 下午
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        // 用HashMap记录一下所有可能都差值及得到此差值的两个数
        Map<Integer, int[]> diffs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //两个数差值都绝对值
                int diff = Math.abs(w[i] - w[j]);
                if (!diffs.containsKey(diff)) {
                    diffs.put(diff, new int[]{w[i], w[j]});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int q = in.nextInt();
            if (diffs.containsKey(q)) {
                System.out.println(diffs.get(q)[0] + " " + diffs.get(q)[1]);
            } else {
                System.out.println("-1 -1");
            }
        }
        in.close();
    }
}
