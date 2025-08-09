package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 28. 实现 strStr()
 * @date: 2021/4/20 1:53 下午
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M28_easy_实现strStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (isSame(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isSame(String haystack, String needle, int index) {
        if (index + needle.length() > haystack.length()) {
            return false;
        }
        for (int i = 0, j = index; i < needle.length(); i++, index++) {
            if (haystack.charAt(index) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}
