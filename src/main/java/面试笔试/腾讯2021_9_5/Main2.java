package 面试笔试.腾讯2021_9_5;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/5 9:16 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int b = in.nextInt();
        in.close();

        // 先二分找交点的x坐标
        double l = 0, r = b;
        while (r - l > 0.00000001) {
            double m = (r + l) / 2;
            double temp = Math.pow(m, k) + m;
            if (temp < b) {
                l = m;
            } else {
                r = m;
            }
        }

        // 定积分求左边的面积
        double area1;
        area1 = (Math.pow(l, k + 1) / (k + 1));

        // 求右边面积
        double area2 = (-l + b) * (b - l) / 2;

        System.out.printf("%f", area1 + area2);
    }
}
