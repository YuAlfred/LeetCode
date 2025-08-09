package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/4 12:46 上午
 * @description : 257. 二叉树的所有路径
 * @modified By  :
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M257_easy_二叉树的所有路径 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, path, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> path, List<String> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : path) {
                sb.append(i);
                sb.append("->");
            }
            res.add(sb.substring(0, sb.length() - 2));
        }
        dfs(root.left, path, res);
        dfs(root.right, path, res);
        path.remove(path.size() - 1);
    }


}















