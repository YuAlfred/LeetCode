package 剑指offer;

import java.util.Arrays;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/8 18:50
 * @description : 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @modified By  :
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class M07_middle_重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        M07_middle_重建二叉树 m07 = new M07_middle_重建二叉树();
        TreeNode node = m07.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("");
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int root = preorder[0];

        TreeNode rootNode = new TreeNode(root);

        int[] leftInorder = null;
        int[] rightInorder = null;
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                leftInorder = Arrays.copyOf(inorder, i);
                rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            return null;
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

        rootNode.left = buildTree(leftPreorder, leftInorder);
        rootNode.right = buildTree(rightPreorder, rightInorder);

        return rootNode;
    }



}
