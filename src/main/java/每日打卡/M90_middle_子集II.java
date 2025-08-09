package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 90. 子集 II
 * @date: 2021/3/31 8:53 上午
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M90_middle_子集II {

    public static void main(String[] args) {
        M90_middle_子集II m = new M90_middle_子集II();
        List<List<Integer>> ans = m.subsetsWithDup(new int[]{1, 2, 3});
        System.out.println();
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(ans, path, nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        ans.add(new ArrayList<>(path));
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                path.add(nums[i]);
                dfs(ans, path, nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }


}
