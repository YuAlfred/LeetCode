package 京东前端8_27;


/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/8/27 8:08 下午
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        StringBuffer bf = new StringBuffer("2");
        for (int i = 0; i < n - 1; i++) {
            add(bf, bf.length() - 1);
        }
        System.out.println(bf);

    }

    public static void add(StringBuffer bf, int i) {

        if (i < 0) {
            bf.insert(0, "2");
            return;
        }

        if (bf.charAt(i) == '2') {
            bf.replace(i, i + 1, "3");
        } else if (bf.charAt(i) == '3') {
            bf.replace(i, i + 1, "5");
        } else {
            bf.replace(i, i + 1, "2");
            add(bf, i - 1);
        }
    }
}
