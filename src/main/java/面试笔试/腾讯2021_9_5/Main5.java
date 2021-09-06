package 面试笔试.腾讯2021_9_5;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/5 8:40 下午
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();

        double pre = 0;
        for (int i = m; i > 0; i--) {
            pre = pre + ((n + i) / (double) i) + 1;
        }
        System.out.printf("%.2f", pre);

    }
}
