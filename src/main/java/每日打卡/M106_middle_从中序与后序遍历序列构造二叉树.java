package 每日打卡;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/25 9:32 上午
 * @description : 106. 从中序与后序遍历序列构造二叉树
 * @modified By  :
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M106_middle_从中序与后序遍历序列构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOf(inorder, i), Arrays.copyOf(postorder, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return root;
    }

}












