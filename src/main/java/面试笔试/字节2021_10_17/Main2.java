package 面试笔试.字节2021_10_17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/10/17 7:07 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        in.close();
        int ans = 0;
        int i = 1;
        while (true) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                i++;
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (nums[j] == i) {
                    ans++;
                    if (j == n - 1) {
                        System.out.println(ans);
                        return;
                    }
                    map.put(i, map.get(i) - 1);
                    while (!map.containsKey(i) || map.get(i) == 0) {
                        i++;
                    }
                }
            }
        }
    }

}
