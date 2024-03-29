package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/2 21:55
 * @description : 剑指 Offer 26. 树的子结构
 * @modified By  :
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M26_middle_树的子结构 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (vlr(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean vlr(TreeNode A, TreeNode B) {

        if (B == null) {
            return true;
        } else if (A == null || A.val != B.val) {
            return false;
        }
        return vlr(A.left, B.left) && vlr(A.right, B.right);
    }
}












