package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1154. 一年中的第几天
 * @date: 2021/12/21 11:05 PM
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 *  
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1154_easy_一年中的第几天 {

    public static void main(String[] args) {
        M1154_easy_一年中的第几天 m = new M1154_easy_一年中的第几天();
        System.out.println(m.dayOfYear("1992-09-14"));
    }

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int moth = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int ans = day;
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < moth; i++) {
            ans += amount[i - 1];
        }
        // 如果超过二月要扣掉二月的日期
        if (moth > 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                ans += 1;
            }
        }
        return ans;
    }


}
