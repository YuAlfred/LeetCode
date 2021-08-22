package 面试笔试.腾讯2021_8_22;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/22 8:21 下午
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        in.close();

        char[] cs = s.toCharArray();
        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = k; i > 0; i--) {
            p = largest(cs, p, n - i);
            sb.append(cs[p]);
            p++;
        }
        System.out.println(sb);
    }

    public static int largest(char[] cs, int i, int j) {
        int ans = i;
        for (int k = i + 1; k <= j; k++) {
            if (cs[k] > cs[ans]) {
                ans = k;
            }
        }
        return ans;
    }
}
