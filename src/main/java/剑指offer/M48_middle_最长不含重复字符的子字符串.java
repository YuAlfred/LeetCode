package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/18 18:10
 * @description : 剑指 Offer 48. 最长不含重复字符的子字符串
 * @modified By  :
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M48_middle_最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            char a = s.charAt(j);
            if (map.containsKey(a)) {
                i = Math.max(i, map.get(a));
            }
            map.put(a, j);
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }

}












