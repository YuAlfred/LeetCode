package 面试笔试.好未来9_11;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/11 6:00 下午
 * @description :
 * @modified By  :
 */

import java.util.HashMap;
import java.util.Scanner;

public class Test21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        int len = 0, maxLen = 0, start = 0, end = 0, index = 0;
        for (int i = 0; i < n; i++) {
            len++;
            if (map.getOrDefault(nums[i], 0) == 0) {
                map.put(nums[i], 1);
                diff++;
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            while (diff > 2) {
                map.put(nums[index], map.get(nums[index]) - 1);
                len--;
                if (map.get(nums[index]) == 0) {
                    diff--;
                }
                index++;
            }
            if (len > maxLen) {
                maxLen = len;
                start = index;
                end = i;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
