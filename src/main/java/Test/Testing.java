package Test;

import java.util.Scanner;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


public class Testing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        in.close();
        char[] s = Integer.toBinaryString(i).toCharArray();
        boolean one = false, zero = false;
        int p = 0;
        for (int j = s.length - 1; j >= 0; j--) {
            if (!zero && s[j] == '0') {
                s[j] = '1';
                zero = true;
                continue;
            }
            if (!one && s[j] == '1') {
                s[j] = '0';
                one = true;
                p = j;
                continue;
            }
        }
        if (one && zero) {
            System.out.println(Integer.valueOf(String.copyValueOf(s), 2));
            zero = false;
            s[p] = '1';

        } else {
            System.out.println(-1);
        }

    }

}