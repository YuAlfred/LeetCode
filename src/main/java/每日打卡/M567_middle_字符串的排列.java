package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 567. 字符串的排列
 * @date: 2021/2/12 12:02 上午
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M567_middle_字符串的排列 {

    public boolean checkInclusion(String s1, String s2) {

        int[] chars = new int[26];
        int[] count = new int[26];
        for (char a : s1.toCharArray()) {
            chars[a - 'a']++;
        }
        int start = 0, tail = 0;
        while (tail < s2.length()) {
            int p = s2.charAt(tail) - 'a';
            count[p]++;
            tail++;
            while (count[p] > chars[p]) {
                count[s2.charAt(start) - 'a']--;
                start++;
            }
            if (tail - start == s1.length()) {
                return true;
            }
        }
        return false;
    }


}
