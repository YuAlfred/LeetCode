package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Testing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            Arrays.sort(a);
            int minTime = 0;

            if (a.length == 0) {
                System.out.println(0);
                continue;
            }
            if (a.length == 1) {
                System.out.println(a[0]);
                continue;
            }

            if (a.length < 3) {
                minTime = Math.max(a[0], a[1]);
                System.out.println(minTime);
                continue;
            }

            if (a.length == 3) {
                minTime = a[1] + a[0] + a[2];
                System.out.println(minTime);
                continue;
            }
            for (int j = a.length - 1; j > 0; j -= 2) {
                if (j >= 3) {
                    if (2 * a[1] <= a[0] + a[j]) {
                        minTime += a[1] + a[0] + a[j] + a[1];
                    } else {
                        minTime += a[j] + a[0] + a[j - 1] + a[0];
                    }
                } else {
                    for (int k = j; k > 0; k--) {
                        minTime += a[k];
                    }
                    if (j % 2 == 0) {
                        minTime += a[0];
                    }
                }
            }
            System.out.println(minTime);
        }
        in.close();
    }
}