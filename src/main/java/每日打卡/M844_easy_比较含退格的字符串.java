package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 844. 比较含退格的字符串
 * @date: 2020/10/20 9:21 下午
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M844_easy_比较含退格的字符串 {

    public static void main(String[] args) {
        backspaceCompare("ab#c", "ad#c");
    }

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for (char a : S.toCharArray()) {
            if (a != '#') {
                sb.append(a);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        for (char a : T.toCharArray()) {
            if (a != '#') {
                tb.append(a);
            } else if (tb.length() > 0) {
                tb.deleteCharAt(tb.length() - 1);
            }
        }
        return sb.toString().equals(tb.toString());

    }

}
