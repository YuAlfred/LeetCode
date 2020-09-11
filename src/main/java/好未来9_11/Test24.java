package 好未来9_11;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/11 6:00 下午
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Test24 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[16];
        for (int i = 0; i < 16; i++) {
            nums[i] = in.nextInt();
        }
        int[][] res = new int[4][4];
        int p = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                res[j][i] = nums[p];
                p++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("\n");
        }
        in.close();
    }
}
