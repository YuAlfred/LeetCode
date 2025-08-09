package 每日打卡;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 131. 分割回文串
 * @date: 2021/3/7 10:41 下午
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M131_middle_分割回文串 {

    public List<List<String>> partition(String s) {

        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        dfs(res, path, s, 0, dp);
        return res;

    }

    public void dfs(List<List<String>> res, List<String> path, String s, int index, boolean[][] dp) {

        if (index == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                path.add(s.substring(index, i + 1));
                dfs(res, path, s, i + 1, dp);
                path.remove(path.size() - 1);
            }
        }
    }

}
