package 面试笔试.美团2021_9_4;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/4 4:20 下午
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();

        char[] c = s.toCharArray();
        int ans = 0;
        while (true) {
            boolean hasAC = false;
            for (int i = 0; i < n - 1; i++) {
                if (c[i] == 'a' && c[i + 1] == 'c') {
                    c[i] = 'c';
                    c[i + 1] = 'a';
                    ans++;
                    hasAC = true;
                }
            }
            if (!hasAC) {
                break;
            }
        }
        System.out.println(ans);
    }

}
