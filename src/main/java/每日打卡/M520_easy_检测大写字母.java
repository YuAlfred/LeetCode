package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/13 10:02
 * @description : 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M520_easy_检测大写字母 {

    public boolean detectCapitalUse(String word) {
        boolean hasLower = false, hasUpper = false;
        for (int i = 1; i < word.toCharArray().length; i++) {
            if (word.charAt(i) <= 'Z' && word.charAt(i) >= 'A') {
                hasUpper = true;
            } else {
                hasLower = true;
            }
        }
        if ((hasLower && hasUpper) || (word.charAt(0) <= 'z' && word.charAt(0) >= 'a' && hasUpper)) {
            return false;
        } else {
            return true;
        }
    }


}
