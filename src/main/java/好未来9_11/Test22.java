package 好未来9_11;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/11 6:00 下午
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Test22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] s1 = new int[5];
        int[] s2 = new int[5];
        for (int i = 0; i < 5; i++) {
            s1[i] = in.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            s2[i] = in.nextInt();
        }
        int i = 0, j = 0;
        while (i < 5 && j < 5) {
            if (s1[i] < s2[j]) {
                System.out.print(s1[i] + " ");
                i++;
            } else {
                System.out.print(s2[j] + " ");
                j++;
            }
        }
        while (i < 5) {
            System.out.print(s1[i] + " ");
            i++;
        }
        while (j < 5) {
            System.out.print(s2[j] + " ");
            j++;
        }
        in.close();
    }
}
