package 程序员面试经典;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 16.21. 交换和
 * @date: 2020/10/21 4:19 下午
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 * <p>
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_21_middle_交换和 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int count1 = 0, count2 = 0;
        for (int i : array1) {
            count1 += i;
        }
        for (int i : array2) {
            count2 += i;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int diff = count1 - count2;
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            int sub = (array1[i] - array2[j]) * 2;
            if (sub == diff) {
                return new int[]{array1[i], array2[j]};
            } else if (sub > diff) {
                j++;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}










