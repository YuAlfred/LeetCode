package 程序员面试经典;

import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/19 14:30
 * @description : 面试题 08.08. 有重复字符串的排列组合
 * @modified By  :
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
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
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_8_middle_有重复字符串的排列组合 {

    public static void main(String[] args) {
        M8_8_middle_有重复字符串的排列组合 m = new M8_8_middle_有重复字符串的排列组合();
        m.permutation("jawaR");
    }


    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        char[] s = S.toCharArray();
        Arrays.sort(s);
        recur(s, 0, res);
        return res.toArray(new String[res.size()]);
    }

    public void recur(char[] s, int index, Set<String> res) {
        if (index == s.length) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i != index && s[i] == s[i - 1]) {
                continue;
            } else {
                swap(s, i, index);
                recur(s, index + 1, res);
                swap(s, i, index);
            }
        }
    }

    public void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }


}
