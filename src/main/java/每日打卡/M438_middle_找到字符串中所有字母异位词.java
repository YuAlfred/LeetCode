package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 438. 找到字符串中所有字母异位词
 * @date: 2021/11/28 10:58 下午
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M438_middle_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new LinkedList<>();
        }
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int n = p.length();
        int[] sCount = new int[26];
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        int start = 0;
        while (start + n - 1 < s.length()) {
            sCount[s.charAt(start + n - 1) - 'a']++;
            if (isSame(sCount, pCount)) {
                ans.add(start);
            }
            sCount[s.charAt(start) - 'a']--;
            start++;
        }
        return ans;
    }

    public boolean isSame(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }


}
