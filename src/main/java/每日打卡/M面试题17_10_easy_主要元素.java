package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.10. 主要元素
 * @date: 2021/7/9 12:14 上午
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M面试题17_10_easy_主要元素 {

    public int majorityElement(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int num = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                num = nums[i];
            }
            if (nums[i] == num) {
                times++;
            } else {
                times--;
            }
        }
        // check
        times = 0;
        for (int i : nums) {
            if (i == num) {
                times++;
            }
        }
        if (times > (nums.length / 2)) {
            return num;
        }
        return -1;
    }


}
