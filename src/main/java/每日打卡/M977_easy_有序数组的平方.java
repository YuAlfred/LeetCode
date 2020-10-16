package 每日打卡;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/10/16 19:23
 * @description : 977. 有序数组的平方
 * @modified By  :
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M977_easy_有序数组的平方 {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int k = res.length - 1; k >= 0; k--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k] = A[i] * A[i];
                i++;
            } else {
                res[k] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}
