package 面试笔试.字节飞书2022_2_27;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2022/2/27 6:35 PM
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        String color = in.next();
        boolean[] isRed = new boolean[n];
        for (int i = 0; i < n; i++) {
            isRed[i] = color.charAt(i) == 'R';
        }
        in.close();

        // 先把前k个染红试试
        int l = 0, r = k - 1;
        int minValue = 0;
        for (int i = 0; i < k; i++) {
            if (!isRed[i]) {
                minValue += a[i];
            }
        }
        int curValue = minValue;
        // 滑动窗口
        while (r < n) {
            
        }
    }

}
