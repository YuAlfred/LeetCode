package 每日打卡;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/20 10:48 下午
 * @description : 78. 子集
 * @modified By  :
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M78_middle_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        res.add(path);
        recur(res,path,0,nums);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> path, int index, int[] nums) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
               path.add(nums[i]);
               res.add(new ArrayList<>(path));
               recur(res,path,i+1,nums);
               path.remove(path.size()-1);
        }
    }

}















