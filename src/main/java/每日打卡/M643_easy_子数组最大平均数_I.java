package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 643. 子数组最大平均数 I
 * @date: 2021/2/4 8:51 上午
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M643_easy_子数组最大平均数_I {
    public double findMaxAverage(int[] nums, int k) {

        double max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = Math.max(max, sum / (double) k);
        int i = 0, j = k;
        for (; j < nums.length; i++, j++) {
            sum -= nums[i];
            sum += nums[j];
            max = Math.max(max, sum / (double) k);
        }
        return max;
    }

}
