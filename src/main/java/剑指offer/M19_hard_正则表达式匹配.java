package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/27 19:14
 * @description : 剑指 Offer 19. 正则表达式匹配
 * @modified By  :
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class M19_hard_正则表达式匹配 {


    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }

    public static boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                //空正则
                if (j == 0) {
                    //都为空返为true;
                    f[i][j] = (i == 0);
                } else {
                    //非空正则,分*和非*

                    //非*
                    if (p.charAt(j - 1) != '*') {
                        //匹配则与之前的结果相同
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                        //不等默认已经为false，不用再设置
                    } else {
                        //为*时 分为参与匹配和不参与匹配两种情况

                        //*为0次数
                        if (j >= 2) {
                            f[i][j] = f[i][j - 2];
                        }

                        //*参与匹配
                        //匹配一次是否成功
                        if (!f[i][j] && i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            //成功后匹配后面的
                            f[i][j] = f[i - 1][j];
                        }
                        //不成功默认false
                    }
                }
            }
        }
        return f[n][m];
    }

}







