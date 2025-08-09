package 程序员面试经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 16.24. 数对和
 * @date: 2020/10/28 4:11 下午
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 * <p>
 * nums.length <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_24_middle_数对和 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 2) {
            return res;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> temp = new LinkedList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                res.add(temp);
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}















