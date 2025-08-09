package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 447. 回旋镖的数量
 * @date: 2021/9/13 12:49 下午
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M447_middle_回旋镖的数量 {

    public int numberOfBoomerangs(int[][] points) {

        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int dis = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                ans += map.getOrDefault(dis, 0);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
        }
        return ans;
    }


}
