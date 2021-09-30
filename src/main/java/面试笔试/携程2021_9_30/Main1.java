package 面试笔试.携程2021_9_30;

import java.util.Scanner;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/30 20:11
 * @description :
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int T = 0;
            int R = 0;
            int I = 0;
            int P = 0;
            for (int j = i; j < n; j++) {
                switch (s.charAt(j)) {
                    case 'T':
                        T++;
                        break;
                    case 'R':
                        R++;
                        break;
                    case 'I':
                        I++;
                        break;
                    case 'P':
                        P++;
                        break;
                }
                if (T == R && I == P) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }


}
