package 面试笔试.阿里2021_9_3;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/3 7:00 下午
 */
public class Main1_1 {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String A = in.next();
        String B = in.next();
        in.close();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i] && (i == 0 || a[i - 1] == b[i - 1])) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}

