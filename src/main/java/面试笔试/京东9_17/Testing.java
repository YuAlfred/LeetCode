package 面试笔试.京东9_17;

import java.util.Scanner;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


public class Testing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        m = m * 100;
        in.close();
        double path = n;
        double down = 0;
        double i = 2;
        int day = 1;
        while (path < m) {
            down += n / i;
            i *= 2;
            path -= down;
            day++;
            path += n;
        }
        System.out.println(day);
    }
}