package 面试笔试.华为2021_9_15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/15 6:47 下午
 */
public class Main1_2 {

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
            // 工位在机器后面
            if (workstations[i] > sterilizers[j]) {
                // 不能覆盖
                if (Math.abs(sterilizers[j] - workstations[i]) > ans) {
                    // 换到下一个机器试试
                    j++;
                } else {
                    // 能覆盖工位++
                    i++;
                }
            } else {
                // 工位在机器前面
                // 不能覆盖
                if (Math.abs(sterilizers[j] - workstations[i]) > ans) {
                    // 看前一个和自己谁扩大影响面积
                    // 如果前一个覆盖成本更小
                    if (j > 0 && (Math.abs(sterilizers[j - 1] - workstations[i]) < Math.abs(sterilizers[j] - workstations[i]))) {
                        // 扩大前一个的覆盖范围
                        ans = Math.abs(sterilizers[j - 1] - workstations[i]);
                        i++;
                    } else {
                        // 如果自己覆盖效果更好
                        ans = Math.abs(sterilizers[j] - workstations[i]);
                    }
                } else {
                    // 能覆盖工位++
                    i++;
                }
            }
        }
        // 如果最后还有工位没覆盖到
        if (i < workstations.length) {
            ans = Math.abs(workstations[workstations.length - 1] - sterilizers[sterilizers.length - 1]);
        }
        System.out.println(ans);
    }

}
