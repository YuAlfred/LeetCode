package 面试笔试.阿里2021_3_8;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/8 6:22 下午
 *
 *
 * 有序数组如 1 2 5 9 11 45，找第k个没出现的数，如第一个没出现的数是3
 */
public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                nums[j] = num;
            }
            int res = nums[0];
            for (int j = 1; j < n; j++) {
                k -= (nums[j] - nums[j - 1] - 1);
                if (k <= 0) {
                    res = (nums[j] + k - 1);
                    break;
                }
            }
            if (k > 0) {
                res = nums[nums.length - 1] + k;
            }
            System.out.println(res);
        }
        in.close();

    }


}
