package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1002. 查找常用字符
 * @date: 2020/10/14 12:25 下午
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1002_easy_查找常用字符 {

    public List<String> commonChars(String[] A) {
        List<String> res = new LinkedList<>();
        int[][] times = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char a : A[i].toCharArray()) {
                times[i][a - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, times[j][i]);
            }
            for (int j = 0; j < min; j++) {
                res.add(Character.toString((char) (i + 'a')));
            }
        }
        return res;
    }
}

















