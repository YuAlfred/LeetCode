package 每日打卡;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 349. 两个数组的交集
 * @date: 2020/11/2 11:43 上午
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M349_easy_两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            if (s1.contains(i)) {
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (int t : res) {
            result[i] = t;
            i++;
        }
        return result;
    }
}












