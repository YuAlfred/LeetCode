package 每日打卡;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 679. 24 点游戏
 * @date: 2021/4/2 9:48 上午
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 * <p>
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/24-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M679_hard_24点游戏 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return fds(list);
    }

    public boolean fds(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-9;
        }

        boolean ans = false;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> newNums = new ArrayList<>(nums);
                newNums.remove(j);
                newNums.remove(i);
                double numI = nums.get(i);
                double numJ = nums.get(j);
                // 加
                newNums.add(numI + numJ);
                ans = ans || fds(newNums);
                newNums.remove(newNums.size() - 1);
                // 减
                newNums.add(numI - numJ);
                ans = ans || fds(newNums);
                newNums.remove(newNums.size() - 1);
                // 减
                newNums.add(numJ - numI);
                ans = ans || fds(newNums);
                newNums.remove(newNums.size() - 1);
                // 乘
                newNums.add(numI * numJ);
                ans = ans || fds(newNums);
                newNums.remove(newNums.size() - 1);
                // 除
                if (numJ != 0) {
                    newNums.add(numI / numJ);
                    ans = ans || fds(newNums);
                    newNums.remove(newNums.size() - 1);
                }
                // 除
                if (numI != 0) {
                    newNums.add(numJ / numI);
                    ans = ans || fds(newNums);
                    newNums.remove(newNums.size() - 1);
                }
                if (ans) {
                    return true;
                }
            }
        }
        return ans;
    }


}
