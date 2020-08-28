package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/8/27 2:07 下午
 * @description : 剑指 Offer 57 - II. 和为s的连续正数序列
 * @modified By  :
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M57_2_easy_和为s的连续正数序列 {

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        int i = 1, j = 2;
        int sum = 1;
        while (i < j && j <= target / 2 + 2) {
            if (sum == target) {
                int[] temp = new int[j - i ];
                for (int k = i; k < j; k++) {
                    temp[k - i] = k;
                }
                list.add(temp);
                sum -= i;
                i++;
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                sum += j;
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}








