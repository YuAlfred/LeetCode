package W8_16;


/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 22:15
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Testing1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String as = in.next();
        String bs = in.next();
        in.close();
        char[] a = as.toCharArray();
        char[] b = bs.toCharArray();
        int n = a.length;
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                score += 20;
            } else {
                score -= 10;
                if (score < 0) {
                    score = 0;
                }
            }
        }
        System.out.println(score);
    }
}
