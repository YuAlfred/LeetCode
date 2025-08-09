package 每日打卡;

import lombok.val;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 435. 无重叠区间
 * @date: 2020/12/31 2:37 下午
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M435_middle_无重叠区间 {

    public static void main(String[] args) {
        val m = new M435_middle_无重叠区间();
        m.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}});
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if (intervals.length < 2) {
            return res;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < e) {
                res++;
            } else {
                e = intervals[i][1];
            }
        }
        return res;
    }

}
