package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 330. 按要求补齐数组
 * @date: 2020/12/29 4:33 下午
 */
public class M330_hard_按要求补齐数组 {


    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }


}
