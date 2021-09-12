package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Long a = 1L;
            for (int i = 0; i < n; i++) {
                a *= in.nextInt();
            }
            Long b = 1L;
            for (int i = 0; i < m; i++) {
                b *= in.nextInt();
            }
            if (a % b == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        in.close();
    }

}
