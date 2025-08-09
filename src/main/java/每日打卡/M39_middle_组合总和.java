package 每日打卡;

import java.util.*;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 9:00 上午
 * @description : 39. 组合总和
 * @modified By  :
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M39_middle_组合总和 {

    public static void main(String[] args) {
        // combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        recur(res, path, candidates, 0, target);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> path, int[] candidates, int index, int target) {
        if (index >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        recur(res, path, candidates, index + 1, target);
        path.add(candidates[index]);
        target -= candidates[index];
        recur(res, path, candidates, index, target);
        path.remove(path.size() - 1);
        return;
    }


}
















