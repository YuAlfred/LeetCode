package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long r = 0, bit = 1;
            while (n > bit * 9) {
                r += bit * 9;
                n -= bit * 9;
                bit *= 10;
            }
            long res = 0;
            for (char a : String.valueOf(n).toCharArray()) {
                res += a - '0';
            }
            for (char a : String.valueOf(r).toCharArray()) {
                res += a - '0';
            }
            System.out.println(res);
        }
        in.close();
    }
}