package 剑指offer;

import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/9 17:29
 * @description : 剑指 Offer 38. 字符串的排列
 * @modified By  :
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M38_middle_字符串的排列 {

    public String[] permutation(String s) {

        Set<String> strings = new HashSet<>();

        char[] chars = s.toCharArray();
        recur(chars, strings, 0);

        return strings.toArray(new String[strings.size()]);
    }

    public void recur(char[] a, Set<String> list, int i) {

        if (i == a.length) {
            list.add(String.copyValueOf(a));
        }

        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            recur(a, list, i + 1);
            swap(a, i, j);
        }

    }

    public void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
