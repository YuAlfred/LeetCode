package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 87. 扰乱字符串
 * @date: 2021/4/16 10:55 上午
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 * 示例 2：
 * <p>
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M87_hard_扰乱字符串 {


    public static void main(String[] args) {
        M87_hard_扰乱字符串 m = new M87_hard_扰乱字符串();
        m.isScramble("great", "rgeat");
    }


    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        // 如果两个输入字符串不等长，直接返回false
        if (s2.length() != length) {
            return false;
        }
        // dp[i1][i2][length] s1从i1开始，s2从i2开始，往后length长度是否和谐，1为true -1为false 0为还未比较
        int[][][] dp = new int[length][length][length + 1];
        dfs(s1, s2, 0, 0, length, dp);
        return dp[0][0][length] == 1;
    }

    public boolean dfs(String s1, String s2, int i1, int i2, int length, int[][][] dp) {
        if (dp[i1][i2][length] != 0) {
            return dp[i1][i2][length] == 1;
        }
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            dp[i1][i2][length] = 1;
            return true;
        }
        // 判断字符个数能不能对上 对不上直接返回false
        if (!basicMatch(s1, s2, i1, i2, length)) {
            dp[i1][i2][length] = -1;
            return false;
        }
        // 开始做切割
        for (int i = 1; i < length; i++) {
            // 不交换
            if (dfs(s1, s2, i1, i2, i, dp) && dfs(s1, s2, i1 + i, i2 + i, length - i, dp)) {
                dp[i1][i2][length] = 1;
                return true;
            }
            //交换
            if (dfs(s1, s2, i1, i2 + length - i, i, dp) && dfs(s1, s2, i1 + i, i2, length - i, dp)) {
                dp[i1][i2][length] = 1;
                return true;
            }
        }
        dp[i1][i2][length] = -1;
        return false;
    }


    // 只判断字符个数是否能对上
    public boolean basicMatch(String s1, String s2, int i1, int i2, int length) {
        int[] charset = new int[26];
        for (int i = length; i > 0; i--, i1++, i2++) {
            charset[s1.charAt(i1) - 'a']++;
            charset[s2.charAt(i2) - 'a']--;
        }
        for (int i : charset) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


}

















