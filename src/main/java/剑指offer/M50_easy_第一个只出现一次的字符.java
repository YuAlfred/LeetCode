package 剑指offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/18 23:37
 * @description : 剑指 Offer 50. 第一个只出现一次的字符
 * @modified By  :
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M50_easy_第一个只出现一次的字符 {

    public static void main(String[] args) {
        firstUniqChar("loveleetcode");
    }

    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char a : s.toCharArray()) {
            map.put(a, !map.containsKey(a));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }


}




