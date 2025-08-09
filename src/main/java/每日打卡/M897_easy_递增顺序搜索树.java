package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 897. 递增顺序搜索树
 * @date: 2021/4/25 4:48 下午
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M897_easy_递增顺序搜索树 {

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


    public TreeNode increasingBST(TreeNode root) {
        return dfs(root)[0];
    }

    public TreeNode[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] left = dfs(root.left);
        TreeNode[] right = dfs(root.right);
        TreeNode head = root;
        TreeNode tail = root;
        if (left != null) {
            head = left[0];
            left[1].right = root;
            root.left = null;
        }
        if (right != null) {
            root.right = right[0];
            tail = right[1];
        }
        return new TreeNode[]{head, tail};
    }
}
