package 每日打卡;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/10/22 21:31
 * @description : 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 *  
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M229_middle_求众数II {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int timeFloor = nums.length / 3;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > timeFloor) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }


}
