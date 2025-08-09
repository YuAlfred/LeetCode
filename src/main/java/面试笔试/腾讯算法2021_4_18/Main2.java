package 面试笔试.腾讯算法2021_4_18;


/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/18 8:52 下午
 */

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int q = in.nextInt();
        for (int k = 0; k < q; k++) {
            int i = in.nextInt();
            int j = in.nextInt();
            String a = s.substring(i - 1);
            String b = t.substring(j - 1);
            int maxLength = b.length();
            int[] minPInB = new int[26];
            for (int l = 0; l < 26; l++) {
                minPInB[l] = -1;
            }
            for (int l = 0; l < b.length(); l++) {
                char c = b.charAt(l);
                int p = c - 'a';
                if (minPInB[p] == -1) {
                    minPInB[p] = b.length() - l;
                }
            }
            for (int l = 0; l < a.length(); l++) {
                char c = a.charAt(l);
                int p = c - 'a';
                p++;
                while (p < 26) {
                    if (minPInB[p] != -1) {
                        // 两个值取最大值
                        maxLength = Math.max(maxLength, a.length() - l + minPInB[p]);
                    }
                    p++;
                }
            }
            System.out.println(maxLength);
        }
        in.close();
    }
}
