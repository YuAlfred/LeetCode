package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/21 2:37
 * @description : 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M58_easy_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        s = s.trim();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            ans++;
            i--;
        }
        return ans;

    }


}
