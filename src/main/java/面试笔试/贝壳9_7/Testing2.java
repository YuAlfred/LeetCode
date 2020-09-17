package 面试笔试.贝壳9_7;


/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing2 {

    public static int mod = 1000000007;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(rec(n, m));
        }
        in.close();
    }

    public static int rec(int n, int m) {
        if (n == 1) {
            return m;
        } else {
            return (int) ((rec(n - 1, m) * (long) m - m) % mod);
        }
    }
}