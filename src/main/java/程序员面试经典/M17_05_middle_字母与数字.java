package 程序员面试经典;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/29 4:01 下午
 * @description : 面试题 17.05.  字母与数字
 * @modified By  :
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-longest-subarray-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_05_middle_字母与数字 {


    public static void main(String[] args) {
        // String[] res = findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
        String[] res = findLongestSubarray(new String[]{"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"});
        System.out.println(res);
    }

    public static String[] findLongestSubarray(String[] array) {
        int[] iArray = new int[array.length];
        iArray[0] = array[0].charAt(0) <= '9' ? 1 : -1;
        for (int i = 1; i < array.length; i++) {
            iArray[i] = array[i].charAt(0) <= '9' ? 1 : -1;
            iArray[i] = iArray[i - 1] + iArray[i];
        }
        Map<Integer, Integer> location = new HashMap<>();
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (iArray[i] == 0) {
                int length = i + 1;
                if (length > max) {
                    max = length;
                    start = 0;
                    end = i + 1;
                }
                continue;
            }
            if (!location.containsKey(iArray[i])) {
                location.put(iArray[i], i);
            } else {
                int length = i - location.get(iArray[i]);
                if (length > max) {
                    max = length;
                    start = location.get(iArray[i]) + 1;
                    end = i + 1;
                }
            }
        }
        return Arrays.copyOfRange(array, start, end);
    }
}













