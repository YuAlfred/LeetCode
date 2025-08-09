package 每日打卡;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 630. 课程表 III
 * @date: 2021/12/14 1:24 PM
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * <p>
 * 返回你最多可以修读的课程数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 * 示例 2：
 * <p>
 * 输入：courses = [[1,2]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M630_hard_课程表III {

    public int scheduleCourse(int[][] courses) {
        // 所有课程按结束时间从前到后排序
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        // 有序列表，记录已选课程的持续时间，大顶
        PriorityQueue<Integer> classQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 当前所选课程上完需要的时间
        int countTime = 0;
        // 遍历每门课
        for (int[] course : courses) {
            countTime += course[0];
            // 如果上这门课不超过结束时间，就直接上
            if (countTime <= course[1]) {
                classQueue.add(course[0]);
            } else {
                // 时间超出了，选入当前课程，然后从已选课程里面挑一个时间最长的踢掉
                classQueue.add(course[0]);
                countTime -= classQueue.poll();
            }
        }
        return classQueue.size();
    }


}
