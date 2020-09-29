package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/29 10:57 上午
 * @description : 面试题 08.14. 布尔运算
 * @modified By  :
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 * <p>
 * 输入: s = "0&0&0&1^1|0", result = 1
 * <p>
 * 输出: 10
 * 提示：
 * <p>
 * 运算符的数量不超过 19 个
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boolean-evaluation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M08_14_middle_布尔运算 {

    public static void main(String[] args) {
        System.out.println(countEval("1^0|0|1", 0));
    }

    public static int countEval(String s, int result) {
        char[] chars = s.toCharArray();
        int[][][] dp = new int[chars.length][chars.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        int res = find(s, dp, 0, s.length() - 1, result);
        return res;
    }

    public static int find(String s, int[][][] dp, int i, int j, int k) {
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if (j - i == 0) {
            if (s.charAt(i) == k + '0') {
                dp[i][j][k] = 1;
                return 1;
            } else {
                dp[i][j][k] = 0;
                return 0;
            }
        } else if (j < i) {
            return 0;
        }
        int res = 0;
        for (int l = i + 1; l < j; l += 2) {
            if (s.charAt(l) == '|') {
                if (k == 0) {
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 0);
                } else {
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 1);
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 0);
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 1);
                }
            } else if (s.charAt(l) == '&') {
                if (k == 0) {
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 0);
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 1);
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 0);
                } else {
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 1);
                }
            } else if (s.charAt(l) == '^') {
                if (k == 0) {
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 1);
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 0);
                } else {
                    res += find(s, dp, i, l - 1, 0) * find(s, dp, l + 1, j, 1);
                    res += find(s, dp, i, l - 1, 1) * find(s, dp, l + 1, j, 0);
                }
            }
        }
        dp[i][j][k] = res;
        return res;
    }

}












