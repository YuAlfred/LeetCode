package 每日打卡;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 164. 最大间距
 * @date: 2020/11/26 10:12 上午
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M164_hard_最大间距 {

    public static void main(String[] args) {
        M164_hard_最大间距 m = new M164_hard_最大间距();
        m.maximumGap(new int[]{1, 10000000});
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int exp = 1;

        List<Integer>[] lists = new List[10];
        for (; exp <= max; exp *= 10) {
            for (int i = 0; i < 10; i++) {
                lists[i] = new LinkedList();
            }
            for (int i : nums) {
                int digit = (i / exp) % 10;
                lists[digit].add(i);
            }
            int i = 0;
            for (int j = 0; j < 10; j++) {
                if (!lists[j].isEmpty()) {
                    for (int k : lists[j]) {
                        nums[i] = k;
                        i++;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }

}









