package 程序员面试经典;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.18. 最短超串
 * @date: 2020/10/30 10:56 上午
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 * <p>
 * big.length <= 100000
 * 1 <= small.length <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_18_middle_最短超串 {

    public static void main(String[] args) {
        M17_18_middle_最短超串 m = new M17_18_middle_最短超串();
        m.shortestSeq(new int[]{521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155},
            new int[]{897261, 934085, 381783, 496153});
    }

    public int[] shortestSeq(int[] big, int[] small) {

        int count = small.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : small) {
            map.put(i, 0);
        }
        int i = 0, j = 0;
        int resI = 0, resJ = Integer.MAX_VALUE;
        while (j < big.length) {
            if (map.containsKey(big[j])) {
                if (map.get(big[j]) == 0) {
                    count--;
                }
                map.put(big[j], map.get(big[j]) + 1);
            }
            j++;
            while (count == 0) {
                if (j - i < resJ - resI) {
                    resJ = j;
                    resI = i;
                }
                if (map.containsKey(big[i])) {
                    map.put(big[i], map.get(big[i]) - 1);
                    if (map.get(big[i]) == 0) {
                        count++;
                    }
                }
                i++;
            }
        }
        return resJ != Integer.MAX_VALUE ? new int[]{resI, resJ - 1} : new int[0];
    }
}




