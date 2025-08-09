package 面试笔试.兴业银行2020_1_22;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/1/22 10:40 下午
 */
public class Main {


    public static void main(String[] args) {
        final Main m = new Main();
        System.out.println(m.change("-100"));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.valueOf("1100011",2));
    }

    public String change(String number) {
        int neg = 1;
        char flag = number.charAt(0);
        if (flag == '-') {
            neg = -1;
            number = number.substring(1);
        } else if (flag == '+') {
            number = number.substring(1);
        } else if (flag > '9' || flag < '0') {
            return "INPUTERROR";
        }
        for (int i = 0; i < number.length(); i++) {
            char a = number.charAt(i);
            if (a > '9' || a < '0') {
                return "INPUTERROR";
            }
        }
        int num = Integer.parseInt(number);
        //注意是15个1
        if (num > 0b111111111111111) {
            return "NODATA";
        }
        String bin = Integer.toBinaryString(num);
        StringBuilder sbBin = new StringBuilder(bin);

        if (neg == -1) {
            while (sbBin.length() < 16) {
                sbBin.insert(0, "1");
            }
        } else {
            while (sbBin.length() < 16) {
                sbBin.insert(0, "0");
            }
        }
        String hex = Integer.toHexString(Integer.valueOf(sbBin.toString(), 2));
        StringBuilder sbH = new StringBuilder(hex);
        while (sbH.length() < 4) {
            sbH.insert(0, "0");
        }
        return sbBin.toString() + "," + sbH.toString().toUpperCase();
    }

}
