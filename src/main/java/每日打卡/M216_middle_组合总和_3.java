package 每日打卡;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 9:22 上午
 * @description : 216. 组合总和 III
 * @modified By  :
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M216_middle_组合总和_3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(res, path, k, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int k, int n, int index) {

        if (n < 0 || k < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= 9; i++) {
            path.add(i);
            dfs(res, path, k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
