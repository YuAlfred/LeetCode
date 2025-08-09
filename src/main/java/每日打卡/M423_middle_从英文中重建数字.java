package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 423. 从英文中重建数字
 * @date: 2021/11/24 12:26 下午
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 * <p>
 * 输入：s = "fviefuro"
 * 输出："45"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M423_middle_从英文中重建数字 {


    public String originalDigits(String s) {
        int[] charNums = new int[26];
        for (char c : s.toCharArray()) {
            charNums[c - 'a']++;
        }
        int[] ans = new int[10];
        ans[0] = charNums['z' - 'a'];
        ans[2] = charNums['w' - 'a'];
        ans[4] = charNums['u' - 'a'];
        ans[8] = charNums['g' - 'a'];
        ans[5] = charNums['f' - 'a'] - ans[4];
        ans[7] = charNums['v' - 'a'] - ans[5];
        ans[1] = charNums['o' - 'a'] - ans[0] - ans[2] - ans[4];
        ans[3] = charNums['h' - 'a'] - ans[8];
        ans[6] = charNums['s' - 'a'] - ans[7];
        ans[9] = charNums['i' - 'a'] - ans[5] - ans[6] - ans[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }


}
