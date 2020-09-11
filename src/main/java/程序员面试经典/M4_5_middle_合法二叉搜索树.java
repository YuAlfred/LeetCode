package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 11:04 上午
 * @description : 面试题 04.05. 合法二叉搜索树
 * @modified By  :
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_5_middle_合法二叉搜索树 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int preMin, int preMax) {
        if (root == null) {
            return true;
        }
        if (root.left != null && (root.left.val >= preMax || root.left.val <= preMin)) {
            return false;
        }
        if (root.right != null && root.right.val <= preMax) {
            return false;
        }
        preMax = Math.max(preMax, root.val);
        return isValid(root.left, preMin, Math.min(preMax,root.val)) && isValid(root.right, preMin, Math.min(preMax, root.val));

    }
}
