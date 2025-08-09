package 每日打卡;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 66. 加一
 * @date: 2021/10/21 7:32 下午
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M66_easy_加一 {


    public int[] plusOne(int[] digits) {
        int p = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (p == 0) {
                break;
            } else {
                if (digits[i] != 9) {
                    digits[i] += 1;
                    p = 0;
                } else {
                    digits[i] = 0;
                }
            }
        }
        if (p == 1) {
            return Stream.concat(Arrays.stream(new int[]{1}).boxed(), Arrays.stream(digits).boxed()).mapToInt(Integer::intValue).toArray();
        }
        return digits;
    }


}
