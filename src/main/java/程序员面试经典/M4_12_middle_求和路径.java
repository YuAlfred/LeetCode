package 程序员面试经典;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/19 12:46
 * @description : 面试题 04.12. 求和路径
 * @modified By  :
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_12_middle_求和路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int res = 0;
    public int temp = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        temp = 0;
        find(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void find(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        temp += root.val;
        if (temp == sum) {
            res++;
        }
        find(root.left, sum);
        find(root.right, sum);
        temp -= root.val;
    }

}
