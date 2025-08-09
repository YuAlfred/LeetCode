package 面试笔试.贝壳9_7;


/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing4大胃王 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] foods = new int[n];
            for (int j = 0; j < n; j++) {
                foods[j] = in.nextInt();
            }
            Arrays.sort(foods);
            int res = 0;
            for (int j = 0; j < n; j++) {
                m -= foods[j];
                if (m < 0) {
                    break;
                } else {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}