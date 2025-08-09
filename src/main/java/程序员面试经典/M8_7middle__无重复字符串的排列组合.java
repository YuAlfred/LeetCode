package 程序员面试经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/19 14:12
 * @description : 面试题 08.07. 无重复字符串的排列组合
 * @modified By  :
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_7middle__无重复字符串的排列组合 {

    public String[] permutation(String S) {
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        char[] s = S.toCharArray();
        recur(res, s, 0);
        return res.toArray(new String[res.size()]);
    }

    public void recur(List<String> res, char[] s, int index) {
        if (index == s.length) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            recur(res, s, index + 1);
            swap(s, i, index);
        }
    }

    public void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }


}
