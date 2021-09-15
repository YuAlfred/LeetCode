package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 162. 寻找峰值
 * @date: 2021/9/15 1:28 下午
 */
public class M162_middle_寻找峰值 {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

}
