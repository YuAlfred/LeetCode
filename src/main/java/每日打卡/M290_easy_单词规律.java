package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 290. 单词规律
 * @date: 2020/12/16 3:27 下午
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M290_easy_单词规律 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] ss = s.trim().split(" ");
        char[] chars = pattern.toCharArray();
        if (ss.length!=chars.length){
            return false;
        }
        for (int i = 0; i < ss.length; i++) {
            String temp = ss[i];
            if (!map.containsKey(chars[i]) && !map.containsValue(temp)) {
                map.put(chars[i], temp);
            } else if (map.containsKey(chars[i]) && !map.get(chars[i]).equals(temp)) {
                return false;
            } else if (!map.containsKey(chars[i]) && map.containsValue(temp)) {
                return false;
            }
        }
        return true;
    }

}














