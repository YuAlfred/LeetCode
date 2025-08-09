package 程序员面试经典;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 10.02. 变位词组
 * @date: 2020/10/12 11:06 下午
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_02_middle_变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = Arrays.toString(a);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> l = new LinkedList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (List<String> l : map.values()) {
            res.add(l);
        }
        return res;
    }
}












