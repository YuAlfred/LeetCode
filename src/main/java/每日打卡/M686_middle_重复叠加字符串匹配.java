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

    public static void main(String[] args) {
        M686_middle_重复叠加字符串匹配 m = new M686_middle_重复叠加字符串匹配();
        System.out.println(m.repeatedStringMatch("aaac", "aac"));

    }

    int mod = 1000000007;

    public int repeatedStringMatch(String a, String b) {
        // 先把B的Hash算出来
        long hashB = 0;
        int bN = b.length();
        int aN = a.length();
        for (int i = 0; i < bN; i++) {
            hashB = (hashB * 26 + (b.charAt(i) - 'a')) % mod;
        }
        // 然后算第一个窗口的Hash
        int start = 0, end = -1;
        long hashWin = 0;
        for (int i = 0; i < bN; i++) {
            end++;
            end %= aN;
            hashWin = (hashWin * 26 + (a.charAt(end) - 'a')) % mod;
        }
        long RM = 1;
        for (int i = 0; i < bN; i++) {
            RM = (RM * 26) % mod;
        }
        // 然后挨个窗口比较
        while (start < aN) {
            // 先看当前窗口是否hash相等，如果相等还要从头比一次
            if (hashB == hashWin && compare(a, b, start)) {
                // 如果有计算k
                int k = bN / aN;
                int rest = bN % aN + start;
                if (rest > 0 && rest <= aN) {
                    k++;
                } else if (rest > aN) {
                    k += 2;
                }
                return k;
            }
            // 否则到下一个窗口
            end++;
            end %= aN;
            hashWin = (hashWin * 26 - (RM * (a.charAt(start) - 'a')) + (a.charAt(end) - 'a')) % mod;
            while (hashWin < 0) {
                hashWin += mod;
            }
            start++;
        }
        return -1;
    }

    public boolean compare(String a, String b, int start) {
        int aN = a.length();
        for (char c : b.toCharArray()) {
            if (c != a.charAt(start)) {
                return false;
            }
            start++;
            start %= aN;
        }
        return true;
    }
}
