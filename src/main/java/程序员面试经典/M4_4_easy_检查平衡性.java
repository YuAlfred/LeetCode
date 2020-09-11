package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 10:53 上午
 * @description : 面试题 04.04. 检查平衡性
 * @modified By  :
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_4_easy_检查平衡性 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // public boolean isBalanced(TreeNode root) {
    //     return treeHeight(root) != -1;
    // }
    // public int treeHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int left = treeHeight(root.left);
    //     int right = treeHeight(root.right);
    //     if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
    //         return -1;
    //     } else {
    //         return Math.max(left, right) + 1;
    //     }
    // }


}














