package 每日打卡;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 179. 最大数
 * @date: 2021/4/12 10:11 上午
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M179_middle_最大数 {

    public static void main(String[] args) {
        M179_middle_最大数 m = new M179_middle_最大数();
        System.out.println(m.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        String[] snums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            snums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(snums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(snums[i]);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }


}
