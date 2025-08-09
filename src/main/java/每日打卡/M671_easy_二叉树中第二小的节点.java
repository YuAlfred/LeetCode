package 每日打卡;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 671. 二叉树中第二小的节点
 * @date: 2021/7/27 12:00 上午
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M671_easy_二叉树中第二小的节点 {

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

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        int min = root.val;
        int nextMin = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            int size = queue.size();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val != min) {
                    if (nextMin == -1) {
                        nextMin = node.val;
                    }else {
                        nextMin = Math.min(nextMin,node.val);
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return nextMin;
    }


}
