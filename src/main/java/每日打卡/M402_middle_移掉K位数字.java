package 每日打卡;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 402. 移掉K位数字
 * @date: 2020/11/15 12:40 下午
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M402_middle_移掉K位数字 {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char a = num.charAt(i);
            if (!deque.isEmpty() && a < deque.peekLast() && k > 0) {
                deque.pollLast();
                k--;
                i--;
            } else {
                deque.add(a);
            }
        }
        while (!deque.isEmpty() && k > 0) {
            deque.pollLast();
            k--;
        }
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        if (deque.size() == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (char a : deque) {
            sb.append(a);
        }
        return sb.toString();
    }

}









