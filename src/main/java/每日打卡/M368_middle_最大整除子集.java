package 每日打卡;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/23 11:13 上午
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M368_middle_最大整除子集 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer>[] linkedLists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            linkedLists[i] = new LinkedList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && temp.size() < linkedLists[j].size()) {
                    temp = linkedLists[j];
                }
            }
            linkedLists[i].add(nums[i]);
            linkedLists[i].addAll(temp);
            if (linkedLists[i].size() > max.size()) {
                max = linkedLists[i];
            }
        }
        return max;
    }


}
