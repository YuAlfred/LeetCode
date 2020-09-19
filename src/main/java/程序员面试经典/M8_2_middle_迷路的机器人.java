package 程序员面试经典;

import com.sun.jmx.snmp.SnmpOid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/19 13:06
 * @description : 面试题 08.02. 迷路的机器人
 * @modified By  :
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_2_middle_迷路的机器人 {


    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return res;
        }
        recur(obstacleGrid, 0, 0, res, visited);
        return res;
    }

    public boolean recur(int[][] obstacleGrid, int x, int y, List<List<Integer>> res, boolean[][] visited) {
        if (x < 0 || x >= obstacleGrid.length || y < 0 || y >= obstacleGrid[0].length
                || obstacleGrid[x][y] == 1 || visited[x][y]) {
            return false;
        }
        List<Integer> node = new ArrayList<>(2);
        node.add(x);
        node.add(y);
        res.add(node);
        visited[x][y] = true;
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return true;
        }
        if (recur(obstacleGrid, x, y + 1, res, visited)) {
            return true;
        }
        if (recur(obstacleGrid, x + 1, y, res, visited)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
