package 每日打卡;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/4/4 10:01
 * @description : 781. 森林中的兔子
 * @modified By  :
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * <p>
 * 返回森林中兔子的最少数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * <p>
 * 输入: answers = []
 * 输出: 0
 * 说明:
 * <p>
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M781_middle_森林中的兔子 {


    public int numRabbits(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (!map.containsKey(answer)) {
                map.put(answer, 1);
                continue;
            }
            int num = map.get(answer) + 1;
            if (num > answer + 1) {
                ans += answer + 1;
                num = 1;
            }
            map.put(answer, num);
        }
        for (Integer i : map.keySet()) {
            ans += (i + 1);
        }
        return ans;
    }


}
