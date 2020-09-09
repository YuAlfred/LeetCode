package 程序员面试经典;

import java.util.HashMap;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 9:55 上午
 * @description : 面试题 01.04. 回文排列 给
 * @modified By  :
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 *  
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1_4_easy_回文排列 {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int old = 0;
        for (char a : s.toCharArray()) {
            if (!map.containsKey(a)) {
                old++;
                map.put(a, 1);
            } else if (map.get(a) % 2 != 0) {
                old--;
                map.put(a, map.get(a) + 1);
            } else {
                old++;
                map.put(a, map.get(a) + 1);
            }
        }
        if (old == 1 || old == 0) {
            return true;
        }
        return false;
    }

}















