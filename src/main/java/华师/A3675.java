package 华师;

import java.util.Scanner;

/**
 * @author ：ty
 * @date ：Created in 2019/3/20 23:31
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class A3675 {

    public static void main(String[] args) {

        long[][] a;

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        a = new long[num][6];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = in.nextInt();
            }
        }

        double p[][] = new double[num][6];

        /**
         * 算概率
         */
        for (int i = 0; i < num; i++) {
            long total = 0;
            for (int j = 0; j < 6; j++) {
                total += a[i][j];
            }
            for (int j = 0; j < 6; j++) {
                p[i][j] = (double) a[i][j] / total;
            }
        }

        /**
         * 算期望
         */
        for (int i = 0; i < num; i++) {
            //初始期望0
            double exp = 0;
            for (int j = 0; j < 6; j++) {
                if (p[i][j] * (j + 1) > exp) {
                    exp = p[i][j] * (j + 1);
                }
            }
            System.out.println(exp);
        }
    }

}
