package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 218. 天际线问题
 * @date: 2021/7/13 12:11 上午
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * <p>
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <p>
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <p>
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * 示例 2：
 * <p>
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings 按 lefti 非递减排序
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-skyline-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M218_hard_天际线问题 {

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        // 当前水位
        int level = 0;
        PriorityQueue<Point> leftPointQueue = new PriorityQueue<Point>(Comparator.comparing(point -> point.x));

        for (int[] building : buildings) {
            while (!leftPointQueue.isEmpty() && leftPointQueue.peek().x < building[0]) {
                Point point = leftPointQueue.poll();
                int newLevel = getHighest(leftPointQueue);
                if (level != newLevel) {
                    // 如果x重复了，取最低
                    if (!ans.isEmpty()) {
                        List<Integer> pre = ans.getLast();
                        if (point.x == pre.get(0)) {
                            if (newLevel >= pre.get(1)) {
                                continue;
                            } else {
                                ans.removeLast();
                            }
                        }
                    }
                    ans.add(Arrays.asList(point.x, newLevel));
                    level = newLevel;
                }
            }
            if (level < building[2]) {
                // 如果x重复了，取最高
                if (!ans.isEmpty()) {
                    List<Integer> pre = ans.getLast();
                    if (building[0] == pre.get(0)) {
                        if (building[2] <= pre.get(1)) {
                            continue;
                        } else {
                            ans.removeLast();
                        }
                    }
                }
                level = building[2];
                ans.add(Arrays.asList(building[0], level));
            }
            leftPointQueue.add(new Point(building[1], building[2]));
        }
        while (!leftPointQueue.isEmpty()) {
            Point point = leftPointQueue.poll();
            int newLevel = getHighest(leftPointQueue);
            if (level != newLevel) {
                // 如果x重复了，取最低
                if (!ans.isEmpty()) {
                    List<Integer> pre = ans.getLast();
                    if (point.x == pre.get(0)) {
                        if (newLevel >= pre.get(1)) {
                            continue;
                        } else {
                            ans.removeLast();
                        }
                    }
                }
                ans.add(Arrays.asList(point.x, newLevel));
                level = newLevel;
            }
        }
        return ans;
    }

    public int getHighest(PriorityQueue<Point> leftPointQueue) {
        int ans = 0;
        for (Point point : leftPointQueue) {
            ans = Math.max(ans, point.y);
        }
        return ans;
    }


}
