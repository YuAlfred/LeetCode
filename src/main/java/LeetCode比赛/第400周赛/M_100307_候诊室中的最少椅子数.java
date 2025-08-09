package LeetCode比赛.第400周赛;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2024/6/3 00:04
 * @description: 给你一个字符串 s，模拟每秒钟的事件 i：
 * <p>
 * 如果 s[i] == 'E'，表示有一位顾客进入候诊室并占用一把椅子。
 * 如果 s[i] == 'L'，表示有一位顾客离开候诊室，从而释放一把椅子。
 * 返回保证每位进入候诊室的顾客都能有椅子坐的 最少 椅子数，假设候诊室最初是 空的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "EEEEEEE"
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 每秒后都有一个顾客进入候诊室，没有人离开。因此，至少需要 7 把椅子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "ELELEEL"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 假设候诊室里有 2 把椅子。下表显示了每秒钟等候室的状态。
 * <p>
 * 秒	事件	候诊室的人数	可用的椅子数
 * 0	Enter	1	1
 * 1	Leave	0	2
 * 2	Enter	1	1
 * 3	Leave	0	2
 * 4	Enter	1	1
 * 5	Enter	2	0
 * 6	Leave	1	1
 * 示例 3：
 * <p>
 * 输入：s = "ELEELEELLL"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 假设候诊室里有 3 把椅子。下表显示了每秒钟等候室的状态。
 * <p>
 * 秒	事件	候诊室的人数	可用的椅子数
 * 0	Enter	1	2
 * 1	Leave	0	3
 * 2	Enter	1	2
 * 3	Enter	2	1
 * 4	Leave	1	2
 * 5	Enter	2	1
 * 6	Enter	3	0
 * 7	Leave	2	1
 * 8	Leave	1	2
 * 9	Leave	0	3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * s 仅由字母 'E' 和 'L' 组成。
 * s 表示一个有效的进出序列。
 */
public class M_100307_候诊室中的最少椅子数 {

    public int minimumChairs(String s) {
        int need_count = 0;
        int cur_count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'E'){
                cur_count++;
                need_count = Math.max(cur_count, need_count);
            }else if (c == 'L'){
                cur_count--;
            }
        }
        return need_count;
    }


}
