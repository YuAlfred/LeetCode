package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/12 13:38
 * @description : M600_hard_不含连续1的非负整数
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M600_hard_不含连续1的非负整数 {

    public static void main(String[] args) {
        M600_hard_不含连续1的非负整数 m = new M600_hard_不含连续1的非负整数();
        System.out.println(m.findIntegers(4));
    }

    public int findIntegers(int n) {

        String num = Integer.toBinaryString(n);
        // 0: 以0结尾不大于num的组合数；1：以1结尾不大于num的组合数；2：以0结尾的所有组合数；3：以1结尾的所有组合数
        int[] dp = new int[]{1, num.charAt(num.length() - 1) == '0' ? 0 : 1, 1, 1};
        for (int i = num.length() - 2; i >= 0; i--) {
            char c = num.charAt(i);
            int[] newDp = new int[4];
            newDp[2] = dp[2] + dp[3];
            newDp[3] = dp[2];
            if (c == '0') {
                newDp[0] = dp[0] + dp[1];
                newDp[1] = 0;
            } else {
                newDp[0] = dp[2] + dp[3];
                newDp[1] = dp[0];
            }
            dp = newDp;
        }
        return dp[0] + dp[1];
    }

}
