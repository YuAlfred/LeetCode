package 面试笔试.美团2021_4_4;

import java.util.Scanner;

/**
 * @author : ty
 * @version :
 * @date : Created in 2021/4/4 10:01
 * @description :
 * @modified By  :
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String sk = String.valueOf(k);
        int[] an = new int[n];
        for (int i = 0; i < n; i++) {
            an[i] = in.nextInt();
        }
        in.close();

        int ans = 0;
        for (int a : an) {
            //找因数
            int alength = String.valueOf(a).length() + 1;
            StringBuilder s = new StringBuilder("1");
            int up = a / 2;
            for (int i = 2; i <= up; i++) {
                if (a % i == 0) {
                    s.append(i);
                }
                if (s.indexOf(sk) != -1) {
                    break;
                }
                //减长
                if (s.length() > alength) {
                    s = s.delete(0, s.length() - alength);
                }
            }
            s.append(a);
            if (s.indexOf(sk) != -1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
