package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 395. 至少有 K 个重复字符的最长子串
 * @date: 2021/2/27 5:24 下午
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M395_middle_至少有K个重复字符的最长子串 {

    public static void main(String[] args) {
        M395_middle_至少有K个重复字符的最长子串 m = new M395_middle_至少有K个重复字符的最长子串();
        System.out.println(m.longestSubstring("bbaaacbd", 3));
    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        if (r - l + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = l; i <= r; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int res = -1;
        int breakP = l;
        for (int i = l; i <= r; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, dfs(s, breakP, i - 1, k));
                breakP = i + 1;
            }
        }
        if (breakP != l) {
            res = Math.max(res, dfs(s, breakP, r, k));
        }
        return res == -1 ? r - l + 1 : res;
    }

}














