package LeetCode比赛.第35场双周赛;

import java.util.Arrays;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/9/19 22:37
 * @description :
 * @modified By  :
 * <p>
 * 5505. 所有排列中的最大和 显示英文描述
 * 通过的用户数16
 * 尝试过的用户数21
 * 用户总通过次数16
 * 用户总提交次数22
 * 题目难度Medium
 * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
 * <p>
 * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
 * <p>
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * 输出：19
 * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * 总和为：8 + 3 = 11。
 * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
 * 输出：11
 * 解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
 * 输出：47
 * 解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] <= 105
 * 1 <= requests.length <= 105
 * requests[i].length == 2
 * 0 <= starti <= endi < n
 */
public class M5505_middle_所有排列中的最大和 {

    public static void main(String[] args) {
        maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{0, 1}, {1, 3}});
    }

    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] in = new int[nums.length];
        int[] out = new int[nums.length];
        for (int i = 0; i < requests.length; i++) {
            in[requests[i][0]]++;
            out[requests[i][1]]++;
        }
        int[] times = new int[nums.length];
        int time = 0;
        for (int i = 0; i < nums.length; i++) {
            time += in[i];
            times[i] = time;
            time -= out[i];
        }
        Arrays.sort(nums);
        Arrays.sort(times);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (times[i] == 0) {
                break;
            }
            int temp = 0;
            temp = (times[i] * nums[i]) % 1000000007;
            res = (res + temp) % 1000000007;
        }
        return res;
    }
}




