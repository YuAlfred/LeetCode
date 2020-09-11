package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 4:48 下午
 * @description : 面试题 04.06. 后继者
 * @modified By  :
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_6_middle_后继者 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean find = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return next(root, p);
    }

    public TreeNode next(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode t1 = next(root.left, p );
        if (find) {
            find = false;
            return root;
        }
        if (root == p) {
            find = true;
        }
        TreeNode t2 = next(root.right, p);
        if (t1 == null) {
            return t2;
        } else {
            return t1;
        }
    }

}
