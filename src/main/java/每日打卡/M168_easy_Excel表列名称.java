package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 168. Excel表列名称
 * @date: 2021/6/29 12:19 上午
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M168_easy_Excel表列名称 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.insert(0, (char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.toString();
    }


}
