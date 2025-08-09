package 面试笔试.贝壳10_26;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2020/10/26 4:17 下午
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            if (x != y && y != z && z != x) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (x == y && y == z) {
                    System.out.println(x + " " + x + " " + x);
                } else {
                    System.out.println(x + " " + y + " " + (Math.min(x, y) - 1));
                }
            }
        }
    }
}
