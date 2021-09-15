package 面试笔试.华为2021_9_15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/15 6:47 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String workstationsString = in.nextLine();
        String sterilizersString = in.nextLine();
        in.close();
        int[] workstations = Arrays.stream(workstationsString.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sterilizers = Arrays.stream(sterilizersString.split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        int i = 0, j = 0;

        Arrays.sort(workstations);
        Arrays.sort(sterilizers);

        while (i < workstations.length && j < sterilizers.length) {
            // 如果当前消毒器可以覆盖当前工位
            if (Math.abs(workstations[i] - sterilizers[j]) <= ans) {
                i++;
            } else if (j < sterilizers.length - 1 && Math.abs(workstations[i] - sterilizers[j + 1]) <= ans) {
                // 如果当前机器不能覆盖但是后面的机器可以，那就该看后面的机器了
                i++;
                j++;
            } else {
                // 当前的和后一个机器都不能覆盖，就选一个最短覆盖距离提升
                ans = Math.min(Math.abs(workstations[i] - sterilizers[j]), j < sterilizers.length - 1 ? Math.abs(workstations[i] - sterilizers[j + 1]) : Integer.MAX_VALUE);
                i++;
            }
        }
        System.out.println(ans);
    }

}
