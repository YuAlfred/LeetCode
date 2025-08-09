package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 387. 字符串中的第一个唯一字符
 * @date: 2020/12/23 10:06 上午
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M387_easy_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        int[] times = new int[26];
        for (char c : s.toCharArray()) {
            times[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (times[a] == 1) {
                return i;
            }
        }
        return -1;
    }

}
