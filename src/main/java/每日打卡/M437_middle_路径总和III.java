package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/28 0:28
 * @description : 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109 
 * -1000 <= targetSum <= 1000 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M437_middle_路径总和III {

    public int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        preSum(root);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(map, root, targetSum);
        return ans;
    }

    public void dfs(Map<Integer, Integer> map, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root.val - targetSum)) {
            ans += map.get(root.val - targetSum);
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(map, root.left, targetSum);
        dfs(map, root.right, targetSum);
        map.put(root.val, map.get(root.val) - 1);
    }


    public void preSum(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val += root.val;
            preSum(root.left);
        }
        if (root.right != null) {
            root.right.val += root.val;
            preSum(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
