package 每日打卡;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1818. 绝对差值和
 * @date: 2021/7/14 12:02 上午
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * <p>
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1818_middle_绝对差值和 {

    public static void main(String[] args) {
        M1818_middle_绝对差值和 m = new M1818_middle_绝对差值和();
        System.out.println(m.minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));

    }


    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int ans = 0;
        int n = nums1.length;
        int[][] compareAns = new int[n][2];
        for (int i = 0; i < n; i++) {
            int ab = Math.abs(nums1[i] - nums2[i]);
            compareAns[i][0] = nums2[i];
            compareAns[i][1] = ab;
            ans = (ans + ab) % mod;
        }

        int change = 0;
        Arrays.sort(nums1);
        Arrays.sort(compareAns, Comparator.comparingInt(o -> o[0]));

        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n - 1 && nums1[i] < compareAns[j][0]) {
                i++;
            }
            int tempChange = Math.abs(nums1[i] - compareAns[j][0]);
            if (i != 0) {
                tempChange = Math.min(tempChange, Math.abs(nums1[i - 1] - compareAns[j][0]));
            }
            tempChange = compareAns[j][1] - tempChange;
            if (tempChange > 0) {
                change = Math.max(change, tempChange);
            }
            j++;
        }
        return (ans + mod - change) % mod;
    }


}
