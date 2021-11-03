package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 407. 接雨水 II
 * @date: 2021/11/3 10:17 上午
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *  
 * <p>
 * 提示:
 * <p>
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M407_hard_接雨水II {

    public int trapRainWater(int[][] heightMap) {
        int ans = 0;
        int m = heightMap.length - 1, n = heightMap[0].length - 1;
        int maxHeight = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                maxHeight = Math.max(heightMap[i][j], maxHeight);
            }
        }
        int[][] water = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                ans += maxHeight - heightMap[i][j];
                water[i][j] = maxHeight;
            }
        }
        boolean changed = false;
        do {
            changed = false;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || i == m || j == 0 || j == n) {
                        if (water[i][j] != heightMap[i][j]) {
                            ans -= water[i][j] - heightMap[i][j];
                            water[i][j] = heightMap[i][j];
                            changed = true;
                        }
                        continue;
                    }
                    int minNearHeight = Math.min(Math.min(water[i + 1][j], water[i - 1][j]),
                            Math.min(water[i][j + 1], water[i][j - 1]));
                    minNearHeight = Math.max(minNearHeight, heightMap[i][j]);
                    if (water[i][j] > minNearHeight) {
                        ans -= water[i][j] - minNearHeight;
                        water[i][j] = minNearHeight;
                        changed = true;
                    }
                }
            }
        } while (changed);
        return ans;
    }
}