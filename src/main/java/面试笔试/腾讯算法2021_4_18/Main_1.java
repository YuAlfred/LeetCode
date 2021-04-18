package 面试笔试.腾讯算法2021_4_18;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/18 9:13 下午
 */

import java.util.*;

public class Main_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        // Set记录一下每一个苹果的重量
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(w[i]);
        }
        for (int i = 0; i < m; i++) {
            int q = in.nextInt();
            boolean find = false;
            for (int j = 0; j < n; j++) {
                int a = w[j];
                if (set.contains(a - q)) {
                    System.out.println((a - q) + " " + a);
                    find = true;
                    break;
                } else if (set.contains(a + q)) {
                    System.out.println(a + " " + (a + q));
                    find = true;
                    break;
                }
            }
            if (!find) {
                System.out.println("-1 -1");
            }
        }
        in.close();
    }
}
