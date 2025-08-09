package 程序员面试经典;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 11:23 上午
 * @description : 面试题 08.04. 幂集
 * @modified By  :
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
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
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_4_middle_幂集 {

    public static void main(String[] args) {
        M8_4_middle_幂集 m = new M8_4_middle_幂集();
        m.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        res.add(new ArrayList<>(path));
        recur(res, path, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            recur(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


}
















