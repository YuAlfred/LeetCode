package 每日打卡;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2023/11/8 23:43
 * @description: 最长平衡子字符串
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 */
public class M2609_easy_最长平衡子字符串 {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public int findTheLongestBalancedSubstring(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;int count0 = 0;int count1 = 0;
        for (int i = 0; i < cs.length; i++) {
            if ((cs[i] ^ '0') == 0) {
                // 0
                if (i == 0 || ((cs[i - 1] ^ '1') == 0)) {
                    count0 = 1;
                    count1 = 0;
                } else {
                    count0++;
                }
            } else {
                // 1
                count1++;
                ans = Math.max(ans, Math.min(count0, count1));
            }
        }
        return ans * 2;
    }


}
