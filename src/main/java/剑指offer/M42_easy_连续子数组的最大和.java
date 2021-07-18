package 剑指offer;

import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/16 19:20
 * @description : 剑指 Offer 42. 连续子数组的最大和
 * @modified By  :
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M42_easy_连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempMax < 0) {
                tempMax = nums[i];
            }else {
                tempMax += nums[i];
            }
            max = Math.max(max,tempMax);
        }
        return max;
    }
}







