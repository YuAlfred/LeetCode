package 程序员面试经典;

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


    public String[] findLongestSubarray(String[] array) {
        int[] iArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            iArray[i] = array[i].charAt(0) <= '9' ? 1 : -1;
        }


    }
}













