package 面试笔试.腾讯后台2021_4_18;


/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/18 7:39 下午
 */

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            String b = in.next();
            if (equal(a, b, 0, a.length() - 1, 0, b.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("No");
            }
        }
        in.close();
    }

    public static boolean equal(String a, String b, int aStart, int aEnd, int bStart, int bEnd) {
        int n = aEnd - aStart + 1;
        //如果长度为奇数
        if (n % 2 == 1) {
            return a.substring(aStart, aEnd + 1).equals(b.substring(bStart, bEnd + 1));
        } else {
            // 如果长度为偶数
            // 先判断条件一
            if (equal(a, b, aStart, aStart + (n / 2) - 1, bStart, bStart + (n / 2) - 1)
                && equal(a, b, aStart + (n / 2), aEnd, bStart + (n / 2), bEnd)) {
                return true;
            }
            // 再判断条件二
            return equal(a, b, aStart, aStart + (n / 2) - 1, bStart + (n / 2), bEnd)
                && equal(a, b, aStart + (n / 2), aEnd, bStart, bStart + (n / 2) - 1);
        }
    }
}
