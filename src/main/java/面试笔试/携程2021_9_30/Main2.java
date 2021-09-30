package 面试笔试.携程2021_9_30;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/30 19:02
 * @description :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextLong();
        }
        long l = in.nextLong();
        long r = in.nextLong();
        in.close();
        Arrays.sort(w);
        System.out.println(countMinX(r + 1, w, m).subtract(countMinX(l, w, m)));
    }

    public static BigInteger countMinX(long x, long[] w, int m) {
        if (x < w[0]) {
            return BigInteger.ZERO;
        }
        int n = w.length;
        for (int i = 0; i < n; i++) {
            if (w[i] == x) {
                return CNM(i + 1, m);
            } else if (w[i] > x) {
                return CNM(i, m).add(countMinX(x - w[i - 1], w, m - 1));
            }
        }
        return n > 1 ? CNM(n - 1, m).add(countMinX(x - w[n - 2], w, m - 1)) : BigInteger.ONE;
    }

    public static BigInteger CNM(int n, int m) {
        if (m > n || m == 0 || n == 0) {
            return BigInteger.ZERO;
        }
        BigInteger a = BigInteger.ONE;
        for (int i = n; i > m; i--) {
            a = a.multiply(new BigInteger(String.valueOf(i)));
        }
        BigInteger b = BigInteger.ONE;
        for (int i = n - m; i > 0; i--) {
            b = b.multiply(new BigInteger(String.valueOf(i)));
        }
        return a.divide(b);
    }
}
