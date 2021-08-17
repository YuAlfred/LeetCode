package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 551. 学生出勤记录 I
 * @date: 2021/8/17 12:04 上午
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 * <p>
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M551_easy_学生出勤记录I {

    public boolean checkRecord(String s) {

        int ACount = 0;
        int LCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                ACount++;
                if (ACount >= 2) {
                    return false;
                }
                LCount = 0;
            } else if (c == 'L') {
                LCount++;
                if (LCount >= 3) {
                    return false;
                }
            } else {
                LCount = 0;
            }
        }
        return true;

    }


}
