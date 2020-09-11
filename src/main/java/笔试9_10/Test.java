package 笔试9_10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/10 4:33 下午
 * @description :
 * @modified By  :
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal n = new BigDecimal(String.valueOf(in.nextInt()));
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String cac = in.next();
            cac = cac.substring(2, cac.length() - 1);
            cac = cac.replaceAll("lg", "l");
            cac = cac.replaceAll("sqrt", "s");
            BigDecimal res = getValue(cac, n);
            if (res.compareTo(new BigDecimal("100000000")) > 0) {
                System.out.println("TLE");
            } else {
                System.out.println(res.toString());
            }
        }

    }

    public static BigDecimal getValue(String s, BigDecimal n) {
        if (s.length() == 1) {
            return n;
        }
        if (s.charAt(0) == '*') {
            return getValue(s.substring(1), n);
        } else if (s.charAt(0) == 'n') {
            return n.multiply(getValue(s.substring(1), n));
        } else if (s.charAt(0) == '(') {
            return getValue(s.substring(1, findIndex(s.substring(1))), n);
        } else if (s.charAt(0) == 'l') {
            return new BigDecimal(Math.log(getValue(s.substring(2, findIndex(s.substring(2)) + 2), n).doubleValue()) / Math.log(2));
        } else {
            return new BigDecimal(Math.sqrt(getValue(s.substring(2, findIndex(s.substring(2)) + 2), n).doubleValue()));
        }
    }

    public static int findIndex(String s) {
        int i = 1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                i++;
            } else if (s.charAt(j) == ')') {
                i--;
            }
            if (i == 0) {
                return j;
            }
        }
        return s.length() - 1;
    }

}
