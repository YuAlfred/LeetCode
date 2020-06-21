package 字节跳动.挑战字符串;

/**
 * @author : ty
 * @version : 翻转字符串里的单词
 * @date : Created in 2020/6/11 21:35
 * @description : 1.0.0
 * @modified By  :
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class M5 {

    public static void main(String[] args) {
        M5 m5 = new M5();
        System.out.println(m5.reverseWords("     "));
    }

    public String reverseWords(String s) {

        if (s.isEmpty() || s == " ") {
            return "";
        }
        String[] result = s.split(" ");
        if (result == null || result.length == 0) {
            return "";
        }

        StringBuffer bf = new StringBuffer();

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i].isEmpty() || result[i] == " ") {
                continue;
            }
            bf.append(result[i]);
            bf.append(" ");
        }
        return bf.substring(0, bf.length() - 1);

    }
}
