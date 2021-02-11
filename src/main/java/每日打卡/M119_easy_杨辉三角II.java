package 每日打卡;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 119. 杨辉三角 II
 * @date: 2021/2/12 12:13 上午
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M119_easy_杨辉三角II {

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        int[] row = new int[rowIndex];
        Arrays.fill(row, 1);
        for (int i = 3; i <= rowIndex; i++) {
            for (int j = i - 2; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>(rowIndex);
        for (int i : row) {
            res.add(i);
        }
        return res;
    }

}
