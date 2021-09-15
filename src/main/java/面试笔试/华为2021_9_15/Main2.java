package 面试笔试.华为2021_9_15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/15 7:33 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int average = in.nextInt();
        int n = in.nextInt() * 2;
        int[] nums = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            total += nums[i];
        }
        in.close();

        if (total % average != 0) {
            System.out.println(0);
            return;
        }

        boolean ans = dfs(nums, 0, average);

        if (!ans) {
            System.out.println(0);
            return;
        }

        int[][] ansNums = new int[n / 2][2];
        for (int i = 0; i < n; i += 2) {
            ansNums[i / 2][0] = Math.max(nums[i], nums[i + 1]);
            ansNums[i / 2][1] = Math.min(nums[i], nums[i + 1]);
        }

        Arrays.sort(ansNums, (o1, o2) -> {
            if (o2[0] + o2[1] == o1[0] + o1[1]) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            } else {
                return o2[0] + o2[1] - o1[0] - o1[1];
            }
        });

        for (int[] num : ansNums) {
            System.out.print(num[0] + " " + num[1] + " ");
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static boolean dfs(int[] nums, int index, int average) {
        int n = nums.length;
        // 如果到最后找到了
        if (index >= n) {
            return true;
        }

        for (int i = index; i < n; i++) {
            // 如果index是奇数要校验一下 否则直接继续就行了
            if ((index & 1) == 1) {
                if ((nums[i] + nums[index - 1]) % average != 0) {
                    continue;
                }
            }
            swap(nums, i, index);
            boolean ans = dfs(nums, index + 1, average);
            if (ans) {
                return ans;
            }
            swap(nums, i, index);
        }
        return false;
    }

}
