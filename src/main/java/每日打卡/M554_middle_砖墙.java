package 每日打卡;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/5/2 11:21
 * @description : 554. 砖墙
 * @modified By  :
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 * <p>
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 *  
 * 提示：
 * <p>
 * n == wall.length
 * 1 <= n <= 104
 * 1 <= wall[i].length <= 104
 * 1 <= sum(wall[i].length) <= 2 * 104
 * 对于每一行 i ，sum(wall[i]) 应当是相同的
 * 1 <= wall[i][j] <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M554_middle_砖墙 {


    public int leastBricks(List<List<Integer>> wall) {
        //记录某列穿过的间隙数
        Map<Integer, Integer> map = new HashMap<>();
        //最大间隙数
        int max = 0;
        for (List<Integer> row : wall) {
            int cur = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                cur += row.get(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                max = Math.max(max, map.get(cur));
            }
        }
        return wall.size() - max;
    }


}
