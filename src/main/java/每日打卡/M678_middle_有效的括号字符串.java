package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 678. 有效的括号字符串
 * @date: 2021/9/13 12:41 下午
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * 注意:
 * <p>
 * 字符串大小将在 [1，100] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M678_middle_有效的括号字符串 {

    public boolean checkValidString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                sb.append(c);
            } else {
                int i = sb.length() - 1;
                while (i >= 0) {
                    if (sb.charAt(i) == '(') {
                        sb.deleteCharAt(i);
                        break;
                    }
                    i--;
                }
                if (i == -1) {
                    i = sb.length() - 1;
                    while (i >= 0) {
                        if (sb.charAt(i) == '*') {
                            sb.deleteCharAt(i);
                            break;
                        }
                        i--;
                    }
                }
                if (i == -1) {
                    return false;
                }
            }
        }

        int leftCount = 0;
        for (char c : sb.toString().toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else {
                leftCount = Math.max(0, leftCount - 1);
            }
        }
        return leftCount <= 0;
    }


}
