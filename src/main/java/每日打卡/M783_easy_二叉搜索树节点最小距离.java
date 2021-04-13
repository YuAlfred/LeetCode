package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 783. 二叉搜索树节点最小距离
 * @date: 2021/4/13 10:13 上午
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M783_easy_二叉搜索树节点最小距离 {

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

    int min = Integer.MAX_VALUE;
    int pre = Integer.MIN_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != Integer.MIN_VALUE) {
            min = Math.min(Math.abs(pre - root.val), min);
        }
        pre = root.val;
        dfs(root.right);
    }
}
