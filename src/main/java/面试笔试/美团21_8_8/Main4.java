package 面试笔试.美团21_8_8;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/8 10:35 上午
 */
public class Main4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        // 将数字出现次数加入hash同时记录两边总值
        int leftTotal = 0, rightTotal = 0;
        for (int i = 0; i < n / 2; i++) {
            int right = n - i - 1;
            leftMap.put(nums[i], leftMap.getOrDefault(nums[i], 0) + 1);
            leftTotal += nums[i];
            rightMap.put(nums[right], rightMap.getOrDefault(nums[right], 0) + 1);
            rightTotal += nums[right];
        }

        if (leftTotal == rightTotal) {
            System.out.println(0);
            return;
        }

        // 用有序set来记录差值
        Set<Integer> diffs = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : leftMap.entrySet()) {
            diffs.add(entry.getValue() - rightMap.getOrDefault(entry.getKey(), 0));
        }
        for (Map.Entry<Integer, Integer> entry : rightMap.entrySet()) {
            diffs.add(leftMap.getOrDefault(entry.getKey(), 0) - entry.getValue());
        }

        if (leftTotal > rightTotal && diffs.contains(-1)) {
            System.out.println(1);
            return;
        }
        if (leftTotal < rightTotal && diffs.contains(1)) {
            System.out.println(1);
            return;
        }

        System.out.println(2);

    }
}
