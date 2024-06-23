package LeetCode比赛.第400周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2024/6/3 00:07
 * @description: 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
 * <p>
 * 返回员工可工作且没有安排会议的天数。
 * <p>
 * 注意：会议时间可能会有重叠。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 第 4 天和第 8 天没有安排会议。
 * <p>
 * 示例 2：
 * <p>
 * 输入：days = 5, meetings = [[2,4],[1,3]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 第 5 天没有安排会议。
 * <p>
 * 示例 3：
 * <p>
 * 输入：days = 6, meetings = [[1,6]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 所有工作日都安排了会议。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= 109
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 1 <= meetings[i][0] <= meetings[i][1] <= days
 */
public class M100311_无需开会的工作日 {
    public int countDays(int days, int[][] meetings) {
        // 按照会议开始时间从小到达排序
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int cur_day = 1;

        for (int[] meeting : meetings) {
            int start_time = meeting[0];
            int end_time = meeting[1];
            if (start_time > cur_day) {
                count += start_time - cur_day;
            }
            cur_day = Math.max(end_time + 1, cur_day);
        }

        if (cur_day <= days) {
            count += days - cur_day + 1;
        }

        return count;

    }
}
