package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Testing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        int t = in.nextInt();
        in.close();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length() - 1; j++) {
                String temp = s.substring(i, j + 1);
                if (!queue.contains(temp)){
                    queue.add(s.substring(i, j + 1));
                }
            }
        }
        String res = null;
        for (int i = 0; i < t ; i++) {
            res = queue.poll();
        }
        System.out.println(res);
    }
}