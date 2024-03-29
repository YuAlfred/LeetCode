package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 9:45 上午
 * @description : 面试题 01.03. URL化
 * @modified By  :
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1_3_easy_URL化 {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (char a : S.toCharArray()) {
            if (a == ' ') {
                sb.append("%20");
            } else {
                sb.append(a);
            }
            length--;
            if (length <= 0) {
                break;
            }
        }
        while (length > 0) {
            sb.append("%20");
            length--;
        }
        return sb.toString();
    }
}














