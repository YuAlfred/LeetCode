package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 171. Excel表列序号
 * @date: 2021/7/30 12:23 上午
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M171_easy_Excel表列序号 {


    public static void main(String[] args) {
        M171_easy_Excel表列序号 m = new M171_easy_Excel表列序号();
        System.out.println(m.titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(columnTitle.length() - i - 1);
            ans += (Math.pow(26, i) * (c - 'A' + 1));
        }
        return ans;
    }


}
