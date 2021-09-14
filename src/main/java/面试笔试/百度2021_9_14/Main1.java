package 面试笔试.百度2021_9_14;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/14 6:32 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int ans = 0;
        int temp = 0;
        for (int i = 1; i <= k; i++) {
            temp += n;
            ans = Math.max(ans, Integer.parseInt(new StringBuilder(String.valueOf(temp)).reverse().toString()));
        }
        System.out.println(ans);
        in.close();
    }

}
