package 每日打卡;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/2/23 10:15
 * @description : 1438. 绝对差不超过限制的最长连续子数组
 * @modified By  :
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1438_middle_绝对差不超过限制的最长连续子数组 {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int left = 0, right = 0;
        int res = 0;
        for (; right < n; right++) {
            add(minDeque, maxDeque, nums[right]);
            while (maxDeque.peek() - minDeque.peek() > limit) {
                remove(minDeque, maxDeque, nums[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public void add(Deque<Integer> minDeque, Deque<Integer> maxDeque, int i) {
        while (!minDeque.isEmpty() && i < minDeque.peekLast()) {
            minDeque.pollLast();
        }
        minDeque.addLast(i);
        while (!maxDeque.isEmpty() && i > maxDeque.peekLast()) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(i);
    }

    public void remove(Deque<Integer> minDeque, Deque<Integer> maxDeque, int i) {
        if (minDeque.peek() == i) {
            minDeque.poll();
        }
        if (maxDeque.peek() == i) {
            maxDeque.poll();
        }
    }

}
