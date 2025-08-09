package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.math.BigInteger;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        StringBuilder sb = new StringBuilder();
        List<BigInteger> list = new LinkedList<>();
        for (char a : s.toCharArray()) {
            if (a <= '9' && a >= '0') {
                sb.append(a);
            } else {
                if (sb.length() != 0) {
                    // for (int i = 0; i < sb.length() - 1; i++) {
                    //     if (sb.charAt(i) == '0') {
                    //         sb.deleteCharAt(i);
                    //         i--;
                    //     } else {
                    //
                    //         break;
                    //     }
                    // }
                    list.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            list.add(new BigInteger(sb.toString()));
        }
        Collections.sort(list);
        for (BigInteger i : list) {
            System.out.println(i.toString());
        }
        in.close();
    }
}
