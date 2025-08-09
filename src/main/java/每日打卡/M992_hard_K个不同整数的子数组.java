package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 992. K 个不同整数的子数组
 * @date: 2021/2/9 5:33 下午
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M992_hard_K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysMaxKDistinct(A, K) - subarraysMaxKDistinct(A, K - 1);
    }

    public int subarraysMaxKDistinct(int[] A, int K) {
        int res = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < A.length) {
            int aj = A[j];
            map.put(aj, map.getOrDefault(aj, 0) + 1);
            if (map.get(aj) == 1) {
                count++;
            }
            j++;

            while (count > K) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    count--;
                }
                i++;
            }
            res += (j - i);
        }
        return res;
    }


}













