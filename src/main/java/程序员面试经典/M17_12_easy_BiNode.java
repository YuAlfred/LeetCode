package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 8:51 下午
 * @description : 面试题 17.12. BiNode
 * @modified By  :
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * <p>
 * 节点数量不会超过 100000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_12_easy_BiNode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return covert(root)[0];

    }


    public TreeNode[] covert(TreeNode root) {
        TreeNode[] res = new TreeNode[]{root, root};
        if (root.left == null && root.right == null) {
            return res;
        }
        if (root.left != null) {
            TreeNode[] l = covert(root.left);
            l[1].right = root;
            root.left = null;
            res[0] = l[0];
        }
        if (root.right != null) {
            TreeNode[] r = covert(root.right);
            root.right = r[0];
            res[1] = r[1];
        }
        return res;
    }
}








