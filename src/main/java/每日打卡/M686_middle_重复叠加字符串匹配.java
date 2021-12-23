package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 686. 重复叠加字符串匹配
 * @date: 2021/12/22 4:38 PM
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 * <p>
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M686_middle_重复叠加字符串匹配 {

    // todo 学习KMP算法
    public int repeatedStringMatch(String a, String b) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length(); i++) {
            int curMin = getMinRepeat(a, b, i);
            if (curMin != -1) {
                min = Math.min(min, curMin);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getMinRepeat(String a, String b, int start) {
        int repeatNum = 1;
        for (char c : b.toCharArray()) {
            if (c != a.charAt(start)) {
                return -1;
            }
            start++;
            if (start == a.length()) {
                start = 0;
                repeatNum++;
            }
        }
        if (start == 0) {
            repeatNum--;
        }
        return repeatNum;
    }
}
