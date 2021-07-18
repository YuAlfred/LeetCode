package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 10.02. 变位词组
 * @date: 2021/7/18 11:07 上午
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M面试题10_02_middle_变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key, list);
        }
        return new LinkedList<>(map.values());
    }

    public String getKey(String str) {
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }


}
