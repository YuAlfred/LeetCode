package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 993. 二叉树的堂兄弟节点
 * @date: 2021/5/17 9:28 上午
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M993_easy_二叉树的堂兄弟节点 {


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


    public boolean isCousins(TreeNode root, int x, int y) {
        int[][] info = new int[101][2];
        dfs(root, info);
        return info[x][0] == info[y][0] && info[x][1] != info[y][1];
    }

    public void dfs(TreeNode root, int[][] info) {
        int val = root.val;
        int deep = info[val][0];
        if (root.left != null) {
            int sVal = root.left.val;
            info[sVal][0] = deep + 1;
            info[sVal][1] = val;
            dfs(root.left, info);
        }
        if (root.right != null) {
            int sVal = root.right.val;
            info[sVal][0] = deep + 1;
            info[sVal][1] = val;
            dfs(root.right, info);
        }
    }


}
