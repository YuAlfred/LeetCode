package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 541. 反转字符串 II
 * @date: 2021/8/20 12:21 上午
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M541_easy_反转字符串II {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += k * 2) {
            reverse(cs, i, i + k - 1);
        }
        return new String(cs);
    }

    public void reverse(char[] cs, int i, int j) {
        if (j >= cs.length) {
            j = cs.length - 1;
        }
        while (i < j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            i++;
            j--;
        }
    }


}
