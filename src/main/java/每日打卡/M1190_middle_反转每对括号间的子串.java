package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1190. 反转每对括号间的子串
 * @date: 2021/5/26 9:39 上午
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1190_middle_反转每对括号间的子串 {

    public int index = 0;

    public String reverseParentheses(String s) {
        return getString(s).toString();
    }

    public StringBuilder getString(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                index++;
                sb.append(getString(s).reverse());
            } else if (s.charAt(index) == ')') {
                index++;
                return sb;
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb;
    }


}
