package 每日打卡;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/21 11:59 上午
 * @description : 538. 把二叉搜索树转换为累加树
 * @modified By  :
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 *  
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 *  
 * <p>
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M538_easy_把二叉搜索树转换为累加树 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        add(root);
        return root;
    }

    public void add(TreeNode root) {
        if (root == null) {
            return;
        }
        add(root.right);
        sum += root.val;
        root.val = sum;
        add(root.left);
    }
}
