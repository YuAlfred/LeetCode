import java.util.HashMap;
import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/6/1 21:16
 * @description : 3. 无重复字符的最长子串
 * @modified By  :
 */
public class A003 {

    public int lengthOfLongestSubstring(String s) {
        int lols = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            lols = Math.max(lols, j - i + 1);
        }
        return lols;
    }


    public static void main(String[] args) {
        A003 a003 = new A003();
        System.out.println(a003.lengthOfLongestSubstring("1234561789"));
    }
}
