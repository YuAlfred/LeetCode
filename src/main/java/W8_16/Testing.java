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
        int[] magic = new int[4];
        magic[0] = in.nextInt();
        magic[1] = in.nextInt();
        magic[2] = in.nextInt();
        magic[3] = in.nextInt();
        in.close();

        int total = magic[0] + magic[1] + magic[2] + magic[3];
        while (true) {
            int average = total / 4;
            if (total < 4) {
                System.out.println(-1);
                return;
            }
            if (magic[0] >= average && magic[1] >= average && magic[2] >= average && magic[3] >= average) {
                System.out.println(average * 4);
                return;
            }
            Arrays.sort(magic);
            magic[0]++;
            magic[3] = magic[3] - 2;
            total--;
        }
    }
}
