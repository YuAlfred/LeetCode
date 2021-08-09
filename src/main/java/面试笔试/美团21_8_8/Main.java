package 面试笔试.美团21_8_8;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/8 10:01 上午
 */
public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();

        if (n <= 1) {
            System.out.println(0);
        }

        // List<Integer> sorted = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            Integer num = set.floor(nums[i] - 1);
            ans += num == null ? 0 : (long) num * (i + 1);
            set.add(nums[i]);
        }

        System.out.println(ans);

    }

}
