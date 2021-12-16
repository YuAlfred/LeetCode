package 每日打卡;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1610. 可见点的最大数目
 * @date: 2021/12/16 2:42 PM
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 * <p>
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * <p>
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 * <p>
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 * <p>
 * 返回你能看到的点的最大数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * 输出：3
 * 解释：阴影区域代表你的视野。在你的视野中，所有的点都清晰可见，尽管 [2,2] 和 [3,3]在同一条直线上，你仍然可以看到 [3,3] 。
 * 示例 2：
 * <p>
 * 输入：points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * 输出：4
 * 解释：在你的视野中，所有的点都清晰可见，包括你所在位置的那个点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * 输出：1
 * 解释：如图所示，你只能看到两点之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-visible-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1610_hard_可见点的最大数目 {

    public static void main(String[] args) {
        System.out.println((Math.atan2(-5, 5) + (2 * Math.PI)) * 360 / (2 * Math.PI));
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> pointDegrees = new LinkedList<>();
        int lx = location.get(0);
        int ly = location.get(1);
        // 重合点个数
        int zeroPoint = 0;
        // 计算每个坐标与location的角度
        for (List<Integer> point : points) {
            int x = point.get(0) - lx;
            int y = point.get(1) - ly;
            if (x == 0 && y == 0) {
                zeroPoint++;
                continue;
            }
            double curAngle = Math.atan2(y, x);
            // 如果为负转成正
            if (curAngle < 0) {
                curAngle += 2 * Math.PI;
            }
            pointDegrees.add(curAngle * 360 / (2 * Math.PI));
        }
        // 无非重合点则直接返回重合点数
        if (pointDegrees.isEmpty()) {
            return zeroPoint;
        }
        // 角度从小到大排序
        Collections.sort(pointDegrees);
        // 滑动窗口
        int l = 0, r = 0;
        // 最大可看到的点数
        // todo 视线度数为0能不能看到东西？ 目前设置可以
        int maxPoints = 1;
        while (l <= r && r < pointDegrees.size() - 1) {
            // 往右看一个然后收缩左边
            r++;
            while (pointDegrees.get(r) - pointDegrees.get(l) > angle) {
                l++;
            }
            maxPoints = Math.max(maxPoints, r - l + 1);
        }
        return maxPoints + zeroPoint;
    }


}
