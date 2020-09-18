package 面试笔试.京东9_17;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


public class Testing2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        List<Integer> magic = new LinkedList<>();
        List<Integer> value = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int tValue = in.nextInt();
            int tMagic = in.nextInt();
            for (int j = 0; j < num; j++) {
                value.add(tValue);
                magic.add(tMagic);
            }
        }
        in.close();
        n = magic.size();
        Integer[] m = magic.toArray(new Integer[n]);
        Integer[] v = value.toArray(new Integer[n]);
        int[] dp = new int[p + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = p; j >= 0; j--) {
                if (v[i - 1] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - v[i - 1]] + m[i - 1]);
                }
            }
        }
        System.out.println(dp[p]);
    }
}