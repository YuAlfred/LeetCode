package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date: 2020/12/1 4:46 下午
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M34_middle_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        //先找左边界
        while (l <= r) {
            mid = (l + (r - l) / 2);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int leftBound = l;
        // 再找右边界
        r = nums.length - 1;
        while (l <= r) {
            mid = (l + (r - l) / 2);
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r <0 || nums[r] != target) {
            return new int[]{-1, -1};
        }
        int rightBound = r;
        return new int[]{leftBound, rightBound};
    }


}



















