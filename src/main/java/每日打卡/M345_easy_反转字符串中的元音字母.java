package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 345. 反转字符串中的元音字母
 * @date: 2021/8/19 12:37 上午
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M345_easy_反转字符串中的元音字母 {

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !needReverse(cs[l])) {
                l++;
            }
            while (l < r && !needReverse(cs[r])) {
                r--;
            }
            if (l < r) {
                char temp = cs[l];
                cs[l] = cs[r];
                cs[r] = temp;
            }
        }
        return new String(cs);
    }

    public boolean needReverse(char c) {
        char character = Character.toLowerCase(c);
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}
