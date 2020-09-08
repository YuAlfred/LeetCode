package 每日打卡;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/8 10:26 上午
 * @description : 77. 组合
 * @modified By  :
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M77_middle_组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        rec(res, temp, n, 1, k);
        return res;
    }

    public void rec(List<List<Integer>> res, List<Integer> temp, int n, int index, int k) {
        if (k == 0) {
            res.add(new LinkedList<>(temp));
        } else {
            for (int i = index; i <= n; i++) {
                temp.add(i);
                rec(res, temp, n, i + 1, k - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}



















