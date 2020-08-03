package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/1 20:21
 * @description : 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @modified By  :
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M21_easy_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        exchange(new int[]{1, 11, 14});
    }


    /**
     * 思路一 首尾指针
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s < e) {

            if (nums[s] % 2 == 1) {
                s++;
                continue;
            }
            if (nums[e] % 2 == 0) {
                e--;
                continue;
            }

            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

        }
        return nums;
    }

    /**
     * 思路二 快慢指针
     * 快慢指针都找奇数，慢指针找第一个奇数，快指针找其存放地点
     *
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        int low = 0;
        int fast = 0;

        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int temp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = temp;
                low++;
            }
            fast++;
        }
        return nums;
    }


}
