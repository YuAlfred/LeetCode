package 面试笔试.贝壳10_26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2020/10/26 4:17 下午
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int[] cards = new int[m];
            int tMin = 0;
            int tMax = 0;
            for (int j = 0; j < m; j++) {
                cards[j] = in.nextInt();
                tMin = Math.min(tMin, cards[j]);
                tMax = Math.max(tMax, cards[j]);
            }
            Arrays.sort(cards);
            int res = 0;
            for (int j = tMin * 2; j <= tMax * 2; j++) {
                int l = 0, r = cards.length - 1;
                int max = 0;
                while (l < r) {
                    if (cards[l] + cards[r] == j) {
                        l++;
                        r--;
                        max++;
                    } else if (cards[l] + cards[r] < j) {
                        l++;
                    } else {
                        r--;
                    }
                }
                res = Math.max(res, max);
            }
            if (res < 2) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }
    }
}
