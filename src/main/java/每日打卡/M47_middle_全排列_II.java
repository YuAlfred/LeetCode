package 每日打卡;

import java.util.*;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 8:55 上午
 * @description : 47. 全排列 II
 * @modified By  :
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M47_middle_全排列_II {

    public static void main(String[] args) {
        M47_middle_全排列_II m = new M47_middle_全排列_II();
        m.permuteUnique(new int[]{1, 1, 2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        recur(res, path, nums, 0, visited);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> path, int[] nums, int index, boolean[] visited) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            recur(res, path, nums, index + 1,visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
