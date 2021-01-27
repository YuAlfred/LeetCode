package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 4. 寻找两个正序数组的中位数
 * @date: 2021/1/26 10:16 上午
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_hard_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        final M4_hard_寻找两个正序数组的中位数 m = new M4_hard_寻找两个正序数组的中位数();
        m.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4});
    }

    public int i1, i2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        i1 = 0;
        i2 = 0;
        int length = nums1.length + nums2.length;
        int part1 = length % 2 == 0 ? find(nums1, nums2, length / 2) : find(nums1, nums2, (length / 2) + 1);
        if ((length & 1) == 1) {
            return part1;
        } else {
            return (part1 + find(nums1, nums2, 1)) / 2.0;
        }
    }

    public int find(int[] nums1, int[] nums2, int k) {
        if (i1 >= nums1.length) {
            i2 += k;
            return nums2[i2 - 1];
        }
        if (i2 >= nums2.length) {
            i1 += k;
            return nums1[i1 - 1];
        }
        if (k == 1) {
            if (nums1[i1] > nums2[i2]) {
                return nums2[i2++];
            } else {
                return nums1[i1++];
            }
        }
        int half = k / 2;
        if (i1 + half - 1 >= nums1.length) {
            half = nums1.length - i1;
        }
        if (i2 + half - 1 >= nums2.length) {
            half = nums2.length - i2;
        }
        if (nums1[i1 + half - 1] > nums2[i2 + half - 1]) {
            i2 += half;
        } else {
            i1 += half;
        }
        return find(nums1, nums2, k - half);
    }
}
