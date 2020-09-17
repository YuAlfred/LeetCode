package 面试笔试.贝壳9_7;


/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.Scanner;

public class Testing1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();
        int sameStr = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (same(s, i)) {
                sameStr = i + 1;
            }
        }
        if (sameStr != 0) {
            System.out.println(n - sameStr + 1);
        } else {
            System.out.println(n);
        }
    }

    public static boolean same(String s, int end) {
        for (int i = 0; i <= end; i++) {
            if (end + i + 1 >= s.length() || s.charAt(i) != s.charAt(end + i + 1)) {
                return false;
            }
        }
        return true;
    }
}