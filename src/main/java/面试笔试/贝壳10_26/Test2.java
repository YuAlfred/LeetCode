package 面试笔试.贝壳10_26;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2020/10/26 4:17 下午
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Set<Integer> set = new HashSet<>();
            boolean next = false;
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                if (next){
                    continue;
                }
                if (set.contains(temp) && temp * temp == m) {
                    System.out.println("yes");
                    next = true;
                }
                set.add(temp);
            }
            if (next) {
                continue;
            }
            for (int s : set) {
                if (m % s == 0 && set.contains(m / s) && m / s != s) {
                    System.out.println("yes");
                    next = true;
                    break;
                }
            }
            if (!next) {
                System.out.println("no");
            }
        }
    }
}
