package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 132. 分割回文串 II
 * @date: 2021/3/8 4:34 下午
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M132_hard_分割回文串II {

    public int minCut(String s) {

        int n = s.length();

        //某段是否回文字串
        boolean[][] isSub = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isSub[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                isSub[i][j] = (s.charAt(i) == s.charAt(j)) && (isSub[i + 1][j - 1]);
            }
        }

        //最小分割
        int[] times = new int[n];
        times[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = times[i - 1] + 1;
            if (isSub[0][i]) {
                times[i] = 0;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (isSub[j][i]) {
                    min = Math.min(times[j - 1] + 1, min);
                }
            }
            times[i] = min;
        }
        return times[n - 1];
    }


}
