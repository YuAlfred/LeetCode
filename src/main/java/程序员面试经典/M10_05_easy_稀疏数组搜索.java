package 程序员面试经典;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 10.05. 稀疏数组搜索
 * @date: 2020/10/14 5:23 下午
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_05_easy_稀疏数组搜索 {
    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            String si = words[i];
            if (si.isEmpty()) {
                continue;
            } else if (si.equals(s)) {
                return i;
            } else if (si.compareTo(s) > 0) {
                break;
            }
        }
        return -1;
    }
}


















