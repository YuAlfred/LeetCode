package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 57. 插入区间
 * @date: 2020/11/4 9:39 上午
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M57_hard_插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        boolean inserted = false;
        for (int[] i : intervals) {
            if (i[0] > newInterval[1]) {
                if (!inserted) {
                    res.add(new int[]{newInterval[0], newInterval[1]});
                    inserted = true;
                }
                res.add(i);
            } else if (i[1] < newInterval[0]) {
                res.add(i);
            } else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        if (!inserted) {
            res.add(new int[]{newInterval[0], newInterval[1]});
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        return result;
    }
}






