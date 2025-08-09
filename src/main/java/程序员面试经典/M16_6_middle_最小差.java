package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 面试题 16.06. 最小差
 * @date : Created in 2020/9/21 9:36 下午
 * @description : 1.0.0
 * @modified By  :
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>
 * 示例：
 * <p>
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_6_middle_最小差 {

    public static void main(String[] args) {
        System.out.println(smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0}));
    }

    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Math.abs(((long) a[0] - b[0]));
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            min = Math.min(min, Math.abs(((long) a[i] - b[j])));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return (int) min;
    }

}












