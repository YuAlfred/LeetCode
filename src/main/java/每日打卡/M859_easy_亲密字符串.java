package 每日打卡;

import java.util.HashMap;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/23 0:20
 * @description : 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * 示例 4：
 * <p>
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M859_easy_亲密字符串 {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int diffNum = 0;
        char[] s1 = new char[2];
        char[] s2 = new char[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffNum++;
                if (diffNum > 2) {
                    return false;
                }
                s1[diffNum - 1] = s.charAt(i);
                s2[diffNum - 1] = goal.charAt(i);
            }
        }
        if (diffNum == 2 && s1[0] == s2[1] && s1[1] == s2[0]) {
            return true;
        } else if (diffNum == 2) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
                if (chars[c - 'a'] >= 2) {
                    return true;
                }
            }
        }
        return false;

    }


}
