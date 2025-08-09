package 程序员面试经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 6:28 下午
 * @description : 面试题 16.19. 水域大小
 * @modified By  :
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_19_middle_水域大小 {


    public int[] pondSizes(int[][] land) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int k = find(land, i, j);
                if (k != 0) {
                    res.add(k);
                }
            }
        }
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    public int find(int[][] land, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
            return 0;
        }
        land[x][y] = -1;
        int res = 1;
        res += find(land, x - 1, y - 1);
        res += find(land, x - 1, y);
        res += find(land, x - 1, y + 1);
        res += find(land, x, y - 1);
        res += find(land, x, y + 1);
        res += find(land, x + 1, y - 1);
        res += find(land, x + 1, y);
        res += find(land, x + 1, y + 1);
        return res;
    }


}












