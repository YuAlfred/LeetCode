package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            TreeMap<Integer, Integer> negative = new TreeMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num < 0) {
                    nums[i] = i == 0 ? 0 : nums[i - 1];
                    negative.put(num, i);
                } else {
                    nums[i] = num + i == 0 ? 0 : nums[i - 1];
                    ans++;
                }
            }
            for (Map.Entry<Integer, Integer> entry : negative.entrySet()) {
                int num = entry.getKey();
                int i = entry.getValue();
                if (nums[i] + num >= 0) {
                    while (i < n) {
                        nums[i] += num;
                        i++;
                    }
                }
            }

        }
        in.close();
    }

}
